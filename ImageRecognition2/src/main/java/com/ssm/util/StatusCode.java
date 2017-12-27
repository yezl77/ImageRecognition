package com.ssm.util;

public enum StatusCode {
	
	PASS(1000,"成功"),REJECT(1003,"登录失败"),REPEATED(1001,"注册用户重复"),CONFIRMING(1002,"用户审核中"),
	NOTEXIST(1004,"不存在的用户");
	
	private int state;

	private String stateInfo;

	private StatusCode(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

}
