package com.example.demo.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xuww
 * @datetime 2021/6/24 11:08 下午
 */
public class NodeChange {

	static String root = "loop";

	static Object lock = new Object();

	static CuratorFramework client = CuratorFrameworkFactory
			.builder()
			.retryPolicy(new ExponentialBackoffRetry(1000, 3))
			.connectString("127.0.0.1:2181")
			.build();

	static ExecutorService executor = new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(),
			ThreadUtils.newThreadFactory("test"));

	public static void main(String[] args) {
		client.start();
		try {
			System.out.println(client.checkExists().forPath("dubbo"));
			System.out.println(client.checkExists().forPath("/adhsahdha"));
		} catch (Exception e) {
			e.printStackTrace();
		}
//		LeaderSelector selector = new LeaderSelector(client, "/leadSelect", new LeaderSelectorListenerAdapter() {
//			@Override
//			public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
//				System.out.println("成为master 角色");
//
//				await();
//
//				System.out.println("完成master 操作");
//			}
//		});
//		selector.autoRequeue();
//		selector.start();
//
//		try {
//			System.out.println("啦啦啦啦");
//			Thread.sleep(Integer.MAX_VALUE);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//		private static void await() throws Exception {
//			synchronized (lock) {
//				lock.wait();
//			}


//		client.start();
//		NodeCache nodeCache = new NodeCache(client, "/create");
//		try {
//			nodeCache.start(true);
//
//			nodeCache.getListenable().addListener(new NodeCacheListener() {
//				@Override
//				public void nodeChanged() throws Exception {
//					System.out.println("Node data update, new data: "+ new String(nodeCache.getCurrentData().getData()));
//				}
//			}, executor);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			client.setData().forPath("/create", "u".getBytes());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			client.delete().forPath("/create");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try {
//			Thread.sleep(Integer.MAX_VALUE);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}


	}
}
