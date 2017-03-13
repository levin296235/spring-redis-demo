package com.gaozw.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gaozw.model.User;

public interface IUserDao {
	
	public User queryByPrimaryKey(@Param("id")Integer id);  
    
    public List<User> queryUserByBatch(Map<String,Object> params);  
      
    public void insertUser(User user);  
      
    public void insertUserByBatch(List<User> list);  
      
    public void deleteByPrimaryKey(@Param("id")Integer id);  
      
    public void delteUserByBatch(Map<String,Object> params);  
      
    public void updateByPrimaryKey(@Param("id")Integer id);  
  
    public List<User> getAllUser();  
}
