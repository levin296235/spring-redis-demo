package cn.springmvc.test;

import java.util.Date;

public class Student {

	private int id;
	private String name;
	private int age;
	private int sex;
	private Date birtday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirtday() {
		return birtday;
	}
	public void setBirtday(Date birtday) {
		this.birtday = birtday;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", sex=" + sex + ", birtday=" + birtday + "]";
	}
	
}
