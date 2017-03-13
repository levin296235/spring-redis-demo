package com.gaozw.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;  
	  
    private String username;  
  
    private String password;  
  
    private Integer age;  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public String getUserName() {  
        return username;  
    }  
  
    public void setUserName(String name) {  
        this.username = name;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password == null ? null : password.trim();  
    }  
  
    public Integer getAge() {  
        return age;  
    }  
  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
}
