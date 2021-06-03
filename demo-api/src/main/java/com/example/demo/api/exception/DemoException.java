package com.example.demo.api.exception;

/**
 * demo异常类
 *
 * @author xuww
 * @datetime 2021/4/23 2:59 下午
 */
public class DemoException extends RuntimeException {
	private static final long serialVersionUID = -5551872655206610996L;
	private String errorCode;
	private String errorMsg;

	public DemoException() {
	}

	public DemoException(DemoException exceptionEnum) {
		this.errorCode = exceptionEnum.getErrorCode();
		this.errorMsg = exceptionEnum.getErrorMsg();
	}

	public DemoException(String responseCode, String message) {
		this.errorCode = responseCode;
		this.errorMsg = message;
	}

	public DemoException(String message) {
		this.errorMsg = message;
	}


	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "DemoException(errorCode=" + this.getErrorCode() + ", errorMsg=" + this.getErrorMsg() + ")";
	}
}
