package com.lzc.demo.response;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponseResult<T> implements Serializable {
	private static final long serialVersionUID = 2719931935414658118L;

	private int status;

	private String message;

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private final Date timestamp;

	private T data;

	private String[] exceptions;

	public ResponseResult(int status, String message) {
		this.status = status;
		this.message = message;
		this.timestamp = new Date();
	}

	public ResponseResult(int status, String message, T data) {
		this(status, message);
		this.data = data;
	}

	public ResponseResult(T data) {
		this(200, "请求成功！");
		this.data = data;
	}

	public ResponseResult(int status, String message, String[] exceptions) {
		this(status, message);
		this.exceptions = exceptions;
	}

	public ResponseResult(ResponseMessage responseMessage) {
		this(responseMessage.getStatus(), responseMessage.getMessage());
	}

	public ResponseResult(ResponseMessage responseMessage, T data) {
		this(responseMessage);
		this.data = data;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("status", status);
		if (message != null) {
			map.put("message", message);
		}
		if (timestamp != null) {
			map.put("timestamp", timestamp);
		}
		if (data != null) {
			map.put("data", data);
		}
		if (exceptions != null) {
			map.put("exceptions", exceptions);
		}
		return map;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String[] getExceptions() {
		return exceptions;
	}

	public void setExceptions(String[] exceptions) {
		this.exceptions = exceptions;
	}
}
