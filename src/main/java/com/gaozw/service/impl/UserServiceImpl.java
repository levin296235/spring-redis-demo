package com.gaozw.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gaozw.dao.IUserDao;
import com.gaozw.model.User;
import com.gaozw.service.IUserService;

@Service("userService")  
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class UserServiceImpl implements IUserService {  
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired 
    private IUserDao userDao;  
      
    public User getUserById(int userId) {  
        return userDao.queryByPrimaryKey(userId);  
    }  
    @CacheEvict(value="userCache",allEntries=true)// 清空accountCache 缓存  
    public void insertUser(User user) {  
        userDao.insertUser(user);  
    }  
    @CachePut(value="userCache",key="#user.getUserName()")// 更新accountCache
    public void addUser(User user) {  
        userDao.insertUser(user);  
    }  
    
    @Cacheable(value="userCache")
    public List<User> getAllUser() {  
    	log.debug("test file ...............");
        return userDao.getAllUser();  
    }  
  
}  