package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.SysUser;
import com.example.demo.ServiceInter.UserService;

@Controller
@RequestMapping("UserList")
public class testController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("Test")
	public String getUser(HttpSession session) {
		List<SysUser> listsession=new ArrayList<SysUser>();
		List<SysUser> list = userService.findAll();
		
		for(SysUser user:list) {
			user.setPassword(user.getPassword().replace(user.getPassword().trim().substring(0,4), "****"));
			listsession.add(user);
		}
		session.setAttribute("list", listsession);
		return "Login/Test";
	}
	
	@RequestMapping("Delete")
	//@ResponseBody
	public  String  deleteUser() {
		//userService.getUserById(user)
		return "LoginPage/userDeList" ;
	}
    
}
