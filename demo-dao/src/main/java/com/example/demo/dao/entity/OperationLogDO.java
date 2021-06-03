package com.example.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.dao.entity.baseEntity.BaseEntityWithExt;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 运营操作日志表
 * </p>
 *
 * @author juejin
 * @since 2021-04-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("operation_log")
public class OperationLogDO extends BaseEntityWithExt {

    private static final long serialVersionUID = 1L;

    /**
     * 项目的名称例如:/风控后台/商品后台
     */
    @TableField("project_name")
    private String projectName;

    /**
     * 项目的code
     */
    @TableField("project_code")
    private String projectCode;

    /**
     * 业务后台请求uri,如/api/list
     */
    @TableField("req_uri")
    private String reqUri;

    /**
     * url对应的id
     */
    @TableField("req_url_id")
    private Long reqUrlId;

    /**
     * 地址的描述
     */
    @TableField("req_url_desc")
    private String reqUrlDesc;

    /**
     * 目录类型：APP：应用、MENU：目录、PAGE：页面、BUTTON：按钮
     */
    @TableField("req_url_type")
    private String reqUrlType;

    /**
     * 客户端操作人的ip
     */
    @TableField("client_ip")
    private String clientIp;

    /**
     * 操作时间
     */
    @TableField("operate_time")
    private LocalDateTime operateTime;

    /**
     * 请求参数
     */
    @TableField("req_param")
    private String reqParam;

    /**
     * 响应参数
     */
    @TableField("res_data")
    private String resData;

    /**
     * 操作者手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 设备号
     */
    @TableField("device_id")
    private String deviceId;

    /**
     * 风险等级2高1中0低默认0
     */
    @TableField("risk_level")
    private Integer riskLevel;

    /**
     * 员工名称(姓名)
     */
    @TableField("employee_account_name")
    private String employeeAccountName;

    /**
     * 员工的账号(登陆名)
     */
    @TableField("employee_account")
    private String employeeAccount;

    /**
     * 触发的小时(0-24)
     */
    @TableField("trigger_hour")
    private Integer triggerHour;

    /**
     * 触发的日期(yyyymmdd)
     */
    @TableField("trigger_date")
    private Integer triggerDate;

    /**
     * 请求id
     */
    @TableField("request_id")
    private String requestId;

    /**
     * 来源appCode
     */
    @TableField("from_app_code")
    private String fromAppCode;


}
