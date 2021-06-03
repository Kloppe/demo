package com.example.demo.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.BaseTest;
import com.example.demo.dao.entity.OperationLogDO;
import com.example.demo.manager.component.oplog.OperationLogManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;

/**
 * 操作manager测试类
 *
 * @author xuww
 * @datetime 2021/4/23 3:22 下午
 */
public class OperationLogManagerTest extends BaseTest {

	@Autowired
	private OperationLogManager operationLogManager;

	@Test
	public void getByIdTest() {

		OperationLogDO operationLogDO = operationLogManager.getById(30167);
		QueryWrapper<OperationLogDO> w= new QueryWrapper();
		operationLogManager.page(new Page<>(1,3),  w);
		System.out.println(operationLogDO.getId());
	}
}
