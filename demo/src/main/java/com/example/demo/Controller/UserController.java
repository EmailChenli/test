package com.example.demo.Controller;


import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.SysUser;
import com.example.demo.Entity.SysUserInfoDe;
import com.example.demo.ServiceInter.UserService;
import com.example.demo.ToolEntity.ResultObj;

@Controller
@RequestMapping("sys")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("Login")
	public String Login(HttpSession session) {
		session.invalidate();
		return "Login/login";
	}
	
	@RequestMapping("toLogin")
	public String toLogin(SysUser user,Model model,HttpSession session) {
		if(userService.userlogin(user)==null) {
			return "page/error";
		}
		session.setAttribute("user", user.getUsername());
		session.setAttribute("role", userService.getRole(user.getUsername()));
		model.addAttribute("role", userService.getRole(user.getUsername()));
		//System.out.println(session.getAttribute("user")+"::"+session.getAttribute("user").toString());
		return "Login/index";
	}
	
	
	@RequestMapping("Quit")
	public String Quit(HttpSession session) {
		session.invalidate();
		return "Login/login";
	}
	
	
	@RequestMapping("Add")
	@ResponseBody
	public ResultObj addUser(SysUser user) {
		//Map<String,String> map= new HashMap<String,String>();
		try {
			userService.addUser(user);
			/*map.put("msg","添加成功");
			map.put("code", "200");*/
			
			return new ResultObj(200,"添加成功");
		}catch(Exception e){
			/*map.put("msg","添加失败");*/
			return new ResultObj(-1,"添加失败");	
		}
		
	}
	@RequestMapping("Update")
	@ResponseBody
	public ResultObj updateUser(SysUser user){
		try {
			userService.updateUser(user);
			/*map.put("msg","添加成功");
			map.put("code", "200");*/
			
			return new ResultObj(200,"修改成功");
		}catch(Exception e){
			/*map.put("msg","添加失败");*/
			return new ResultObj(-1,"修改失败");	
		}
	}
	
	@RequestMapping("Delete")
	@ResponseBody
	@Transactional
	public  ResultObj  deleteUser(SysUser user) {
		try {
			userService.deUserInfo(userService.getUserById(userService.getId(user)));
			userService.deleteUser(userService.getId(user));
			/*map.put("msg","添加成功");
			map.put("code", "200");*/
			
			return new ResultObj(200,"删除成功");
		}catch(Exception e){
			/*map.put("msg","添加失败");*/
			return new ResultObj(-1,"删除失败");	
		}
	}
	
	@RequestMapping("DeDelete")
	@ResponseBody
	public  ResultObj  deleteDeUser(SysUserInfoDe deUser) {
		try {
			System.out.println(deUser.toString());
			userService.deUserDelete(deUser.getId());;
			/*map.put("msg","添加成功");
			map.put("code", "200");*/
			
			return new ResultObj(200,"删除成功");
		}catch(Exception e){
			/*map.put("msg","添加失败");*/
			return new ResultObj(-1,"删除失败");	
		}
	}
	
	@RequestMapping("Change")
	public String changeChangeUser(@Param("password")String password,HttpSession session) {
		try {
			System.out.println(password);
			userService.changePass(password, session.getAttribute("user").toString());
			return "page/success";
		}catch(Exception e){
			return "page/error";
		}
	}
	
}
