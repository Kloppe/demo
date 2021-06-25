package com.example.demo.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;

/**
 * @author xuww
 * @datetime 2021/6/25 11:15 上午
 */
public class PathChildrenCacheTest {

	/**
	 * Path Cache用来监控一个ZNode的子节点. 当一个子节点增加， 更新，删除时， Path Cache会改变它的状态， 会包含最新的子节点，
	 * 子节点的数据和状态，而状态的更变将通过PathChildrenCacheListener通知。
	 *
	 * StartMode有下面几种：
	 *
	 * NORMAL：正常初始化。
	 * BUILD_INITIAL_CACHE：在调用start()之前会调用rebuild()。
	 * POST_INITIALIZED_EVENT： 当Cache初始化数据后发送一个PathChildrenCacheEvent.Type#INITIALIZED事件
	 *
	 * 注意：使用cache，依然要调用它的start()方法，使用完后调用close()方法。
	 *
	 * 注意：如果new PathChildrenCache(client, PATH, true)中的参数cacheData值设置为false，则示例中的event.getData().getData()、data.getData()
	 * 将返回null，cache将不会缓存节点数据。
	 *
	 * 注意：示例中的Thread.sleep(10)可以注释掉，但是注释后事件监听的触发次数会不全，这可能与PathCache的实现原理有关，不能太过频繁的触发事件！
	 */


	private static final String PATH = "/example/pathCache";

	public static void main(String[] args) throws Exception {
		TestingServer server = new TestingServer();
		CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(), new ExponentialBackoffRetry(1000, 3));
		client.start();
		PathChildrenCache cache = new PathChildrenCache(client, PATH, true);
		cache.start();
		PathChildrenCacheListener cacheListener = (client1, event) -> {
			System.out.println("事件类型：" + event.getType());
			if (null != event.getData()) {
				System.out.println("节点数据：" + event.getData().getPath() + " = " + new String(event.getData().getData()));
			}
		};
		cache.getListenable().addListener(cacheListener);
		client.create().creatingParentsIfNeeded().forPath("/example/pathCache/test01", "01".getBytes());
		Thread.sleep(10);
		client.create().creatingParentsIfNeeded().forPath("/example/pathCache/test02", "02".getBytes());
		Thread.sleep(10);
		client.setData().forPath("/example/pathCache/test01", "01_V2".getBytes());
		Thread.sleep(10);
		for (ChildData data : cache.getCurrentData()) {
			System.out.println("getCurrentData:" + data.getPath() + " = " + new String(data.getData()));
		}
		client.delete().forPath("/example/pathCache/test01");
		Thread.sleep(10);
		client.delete().forPath("/example/pathCache/test02");
		Thread.sleep(1000 * 5);
		cache.close();
		client.close();
		System.out.println("OK!");
	}
}
