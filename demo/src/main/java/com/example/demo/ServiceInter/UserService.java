package com.example.demo.ServiceInter;

import java.util.List;

import com.example.demo.Entity.SysUser;
import com.example.demo.Entity.SysUserInfoDe;
import com.example.demo.ToolEntity.PageLimit;

public interface UserService {
	//用户信息处理
	public SysUser userlogin(SysUser user);
	public String getRole(String username);
	public List<SysUser> findAll();
	public void addUser(SysUser user);
	public List<SysUser> findList(PageLimit pageLimit);
	public int getCount();
	public void deleteUser(int userId);
	public void updateUser(SysUser user);
	public int getId(SysUser user);
	public SysUser getUserById(int userId);
	public void deUserInfo(SysUser user);
	public List<SysUser> findLikeList(SysUser sysUser,PageLimit pageLimit);
	public SysUser changePass(String password,String username);
	
	//删除用户信息处理
	public int getDeCount();
	public List<SysUserInfoDe> findDeList(PageLimit pageLimit);
	public void deUserDelete(Long deuserId);
	public int getDeId(SysUserInfoDe deUser);
}
