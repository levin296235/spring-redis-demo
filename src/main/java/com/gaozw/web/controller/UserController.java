package com.gaozw.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaozw.model.User;
import com.gaozw.service.IUserService;
import com.gaozw.service.impl.UserServiceImpl;

@Controller  
@RequestMapping("/user")  
public class UserController {  
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired 
    @Qualifier("userService")
    private IUserService userService;  
      
    @RequestMapping("/userList")  
    public String userList(HttpServletRequest request,Model model){  
        List<User> uList = userService.getAllUser(); 
        log.debug("userController ......method:userList....");
        model.addAttribute("uList", uList);  
        return "userList";  
    }  
      
    @RequestMapping("/showUser")  
    public String showUser(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";  
    }  
      
    @RequestMapping("/addUserUI")  
    public String addUserUI(){  
        return "addUser";  
    }  
      
    @RequestMapping("/addUser")  
    public String addUser(HttpServletRequest request,Model model){  
        User user = new User();  
        user.setUserName(String.valueOf(request.getParameter("name")));  
        user.setPassword(String.valueOf(request.getParameter("password")));  
        user.setAge(Integer.parseInt(String.valueOf(request.getParameter("age"))));  
        userService.addUser(user);  
        return "redirect:/user/userList";  
    }  
}  