package com.joaoflach.main.config;

public enum OperatorSign {

	GREATER_THAN(1), EQUALS(2), LESS_THAN(3);
	
	private OperatorSign(int code) {
		
	}
	
	private int code;
	
	public int getCode() {
		return this.code;
	};
}
