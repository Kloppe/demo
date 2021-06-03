package com.example.demo;

import com.example.demo.web.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 基本测试类
 *
 * @author xuww
 * @datetime 2021/4/23 3:19 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseTest {
}
