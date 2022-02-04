package com.example.domain;

public class Member {
	private String name;
	private Integer age;
	private Integer depId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDepId() {
		return depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age
				+ ", depId=" + depId + "]";
	}
	
	
}
