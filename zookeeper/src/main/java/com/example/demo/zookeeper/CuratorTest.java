package com.example.demo.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.StandardCharsets;

/**
 * curator测试
 *
 * @author xuww
 * @datetime 2021/6/24 9:59 下午
 */
public class CuratorTest {

	static String root = "loop";

	static CuratorFramework client = CuratorFrameworkFactory
			.builder()
			.namespace(root)
			.retryPolicy(new ExponentialBackoffRetry(1000, 3))
			.connectString("127.0.0.1:2181")
			.build();

	public static void aVoid() {
		client.start();

		try {
			client.delete().guaranteed().forPath("/create");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 新增
		try {
			client.create()
					.creatingParentsIfNeeded()
					.forPath( "/create", "create".getBytes(StandardCharsets.UTF_8));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("create -> 成功");

		Stat stat = new Stat();
		try {
			System.out.println(new String(client.getData().storingStatIn(stat).forPath("/create"), StandardCharsets.UTF_8));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// set data 返回 Stat
			System.out.println("Success set node old version=" + stat.getVersion() + "new version=" +
					client.setData().forPath("/create").getVersion());
		} catch (Exception e) {
			e.printStackTrace();
		}




	}
}
