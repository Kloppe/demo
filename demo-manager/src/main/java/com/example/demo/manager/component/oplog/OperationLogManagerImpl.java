package com.example.demo.manager.component.oplog;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.entity.OperationLogDO;
import com.example.demo.dao.mapper.OperationLogMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 运营操作日志表 服务实现类
 * </p>
 *
 * @author juejin
 * @since 2021-04-23
 */
@Service
public class OperationLogManagerImpl extends ServiceImpl<OperationLogMapper, OperationLogDO> implements OperationLogManager {

}
