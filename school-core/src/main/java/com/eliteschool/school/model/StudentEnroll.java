package com.eliteschool.school.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="studentEnroll")
public class StudentEnroll {
	@Id
	private String id;
	private String name;
	private int age;
	private String address;
		
	public StudentEnroll() {
		super();
	}
	
	public StudentEnroll(String id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "StudentEnroll [id=" + id + ", name=" + name + ", age=" + age
				+ ", address=" + address + "]";
	}
		
}
