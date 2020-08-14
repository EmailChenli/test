package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Dimission;
import com.example.demo.Entity.DimissionInfoDe;
import com.example.demo.Entity.Entry;
import com.example.demo.Entity.EntryInfoDe;
import com.example.demo.Entity.SysUser;
import com.example.demo.Entity.SysUserInfoDe;
import com.example.demo.ServiceInter.DimissionService;
import com.example.demo.ServiceInter.EntryService;
import com.example.demo.ServiceInter.UserService;
import com.example.demo.ToolEntity.PageLimit;
import com.example.demo.ToolEntity.Result;

@Controller
@RequestMapping("Page")
public class PageDataController {
	@Autowired
	private UserService userService;
	
	@Autowired 
	private EntryService entryService;

	@Autowired
	private DimissionService dimissionService;
	
	@RequestMapping("userList")
	@ResponseBody
	public Result<?> getUserList(PageLimit pageLimit,SysUser sysUser){
		if(sysUser.getUsername() == null) {
		PageLimit pageL = new PageLimit();
		pageL.setLimit(pageLimit.getLimit());
		pageL.setPage((pageLimit.getPage()-1)*pageLimit.getLimit());
		List<SysUser> userList = userService.findList(pageL);	
		Result<List<SysUser>> result=new Result<List<SysUser>>(0,userService.getCount(),"获取成功", userList);
		return result;
		}else {
			sysUser.setRole("%"+sysUser.getRole()+"%");
			sysUser.setUsername("%"+sysUser.getUsername()+"%");
			
			PageLimit pageL = new PageLimit();
			pageL.setLimit(pageLimit.getLimit());
			pageL.setPage((pageLimit.getPage()-1)*pageLimit.getLimit());
			List<SysUser> userList = userService.findLikeList(sysUser,pageL);
			Result<List<SysUser>> result=new Result<List<SysUser>>(0,userService.getCount(),"获取成功", userList);
			return result;
		}
	}
	
	@RequestMapping("userDeList")
	@ResponseBody
	public Result<?> getDeUserList(PageLimit pageLimit){

		PageLimit pageL = new PageLimit();
		pageL.setLimit(pageLimit.getLimit());
		pageL.setPage((pageLimit.getPage()-1)*pageLimit.getLimit());
		List<SysUserInfoDe> userList = userService.findDeList(pageL);	
		Result<List<SysUserInfoDe>> result=new Result<List<SysUserInfoDe>>(0,userService.getDeCount(),"获取成功", userList);
		return result;
		
	}
	
	@RequestMapping("entryList")
	@ResponseBody
	public Result<?> getEntryList(PageLimit pageLimit,Entry entry){
		if(entry.getName() == null) {
		PageLimit pageL = new PageLimit();
		pageL.setLimit(pageLimit.getLimit());
		pageL.setPage((pageLimit.getPage()-1)*pageLimit.getLimit());
		List<Entry> entryList = entryService.getEntryList(pageL);
		Result<List<Entry>> result=new Result<List<Entry>>(0,entryService.getCount(),"获取成功", entryList);
		return result;
		}else {
			entry.setName("%"+entry.getName()+"%");
			entry.setDate("%"+entry.getDate()+"%");
		
			PageLimit pageL = new PageLimit();
			pageL.setLimit(pageLimit.getLimit());
			pageL.setPage((pageLimit.getPage()-1)*pageLimit.getLimit());
		
			List<Entry> entryList = entryService.getEntrylikeList(pageLimit, entry);
			
			Result<List<Entry>> result=new Result<List<Entry>>(0,entryService.getCount(),"获取成功", entryList);
			return result;
		}
	}
	
	@RequestMapping("entryDeList")
	@ResponseBody
	public Result<?> getDeEntryList(PageLimit pageLimit){
		PageLimit pageL = new PageLimit();
		pageL.setLimit(pageLimit.getLimit());
		pageL.setPage((pageLimit.getPage()-1)*pageLimit.getLimit());
		List<EntryInfoDe> entryList = entryService.findDeList(pageL);
		Result<List<EntryInfoDe>> result=new Result<List<EntryInfoDe>>(0,entryService.getDeCount(),"获取成功", entryList);
		return result;
	}
	
	@RequestMapping("dimissionList")
	@ResponseBody
	public Result<?> getDimissionList(PageLimit pageLimit,Dimission dimission){
		if(dimission.getName() == null) {
		PageLimit pageL = new PageLimit();
		pageL.setLimit(pageLimit.getLimit());
		pageL.setPage((pageLimit.getPage()-1)*pageLimit.getLimit());
		List<Dimission> dimissionList = dimissionService.getListLimit(pageL);
		Result<List<Dimission>> result=new Result<List<Dimission>>(0,dimissionService.getCount(),"获取成功", dimissionList);
		return result;
		}else {
			System.out.println(dimission.getName());
			dimission.setName("%"+dimission.getName()+"%");
			dimission.setDate("%"+dimission.getDate()+"%");
			PageLimit pageL = new PageLimit();
			pageL.setLimit(pageLimit.getLimit());
			pageL.setPage((pageLimit.getPage()-1)*pageLimit.getLimit());
			List<Dimission> dimissionList = dimissionService.getListLikeLimit(pageLimit, dimission);
			Result<List<Dimission>> result=new Result<List<Dimission>>(0,dimissionService.getCount(),"获取成功", dimissionList);
			return result;
		}
	}
	
	@RequestMapping("dimissionDeList")
	@ResponseBody
	public Result<?> getDimissionDeList(PageLimit pageLimit){
		PageLimit pageL = new PageLimit();
		pageL.setLimit(pageLimit.getLimit());
		pageL.setPage((pageLimit.getPage()-1)*pageLimit.getLimit());
		List<DimissionInfoDe> dimissionList = dimissionService.findDeDimissionLimit(pageL);
		Result<List<DimissionInfoDe>> result=new Result<List<DimissionInfoDe>>(0,dimissionService.getDeCount(),"获取成功", dimissionList);
		return result;
	}
}
