package io.users.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {	
	
	@NotNull
	@Size(min=3, max=20)
	private String name;
	
	@NotNull
	@Size(min=3, max=20)
	private String birthday;
	
	@NotNull
	@Min(1)
	private int age;
	private int userId;
	private static int nextId = 1;
	
	public User() {
		userId = nextId;
		nextId++;
	}
	public User(String name, String birthday, int age) {
		this();
		this.name = name;
		this.birthday = birthday;
		this.age = age;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
