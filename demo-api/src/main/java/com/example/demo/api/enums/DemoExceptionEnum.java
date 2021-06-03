package com.example.demo.api.enums;

/**
 * 异常枚举类
 *
 * @author xuww
 * @datetime 2021/4/23 3:09 下午
 */
public enum DemoExceptionEnum {
	//全局系统错误
	BUSY_ERROR("00001", "系统繁忙"),
	RATE_LIMIT_ERROR("00002", "服务限流"),
	//全局业务错误

	;

	private String code;
	private String msg;

	DemoExceptionEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
