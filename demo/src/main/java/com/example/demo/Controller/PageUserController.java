package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class PageUserController {
	@RequestMapping("userList")
	public String getUserPage() {
		return "LoginPage/userList";
	} 
	
	@RequestMapping("userDeList")
	public String getDeUserPage() {
		return "LoginPage/userDeList";
	} 
	
	
	@RequestMapping("entryList")
	public String getEntryPage() {
		return "LoginPage/entryList";
	}
	@RequestMapping("entryDeList")
	public String getDeEntryPage() {
		return "LoginPage/entryDeList";
	} 
	
	@RequestMapping("dimissionList")
	public String getDimissionPage() {
		return "LoginPage/dimissionList";
	} 

	@RequestMapping("dimissionDeList")
	public String getDeDimissionPage() {
		return "LoginPage/dimissionDeList";
	} 
	@RequestMapping("welcome")
	public String getWelcomePage() {
		return "LoginPage/Welcome";
	} 
	@RequestMapping("change")
	public String getChangePage() {
		return "LoginPage/change";
	} 
}
