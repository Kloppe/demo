package com.example.demo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @author xuww
 * @datetime 2021/4/21 5:57 下午
 */
@SpringBootApplication
@ComponentScan(value = {"com.example.demo"})
@MapperScan("com.example.demo.dao.mapper")
public class Application {

	public static void main(String[] args) {
		try {
			SpringApplication.run(Application.class, args);
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}


}
