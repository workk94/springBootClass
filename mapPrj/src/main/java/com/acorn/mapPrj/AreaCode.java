package com.acorn.mapPrj;



public class AreaCode {
	
	String code;
	String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AreaCode [code=" + code + ", name=" + name + "]";
	}
	public AreaCode(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	
	
	public AreaCode() {
		// TODO Auto-generated constructor stub
	}

}
