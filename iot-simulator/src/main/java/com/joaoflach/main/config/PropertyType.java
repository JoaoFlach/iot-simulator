package com.joaoflach.main.config;

public enum PropertyType {
	NUMBER("Number"), TEXT("Text"), BOOLEAN("Boolean");
	
	private PropertyType(String type) {
		this.type = type;
	}
	
	private String type;
	
	public boolean equals(String in) {
		return this.type.equalsIgnoreCase(in);
	}
}
