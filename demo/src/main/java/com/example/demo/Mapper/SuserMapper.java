package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Entity.SysUser;
import com.example.demo.ToolEntity.PageLimit;

@Mapper
public interface SuserMapper {
	
	//查找满足条件的用户
	@Select("select * from sysuser where username=#{username} and password=#{password}")
	public SysUser findUser(SysUser user);
	
	
	//获取权限
	@Select("select role from sysuser where username=#{username}")
	public String getRole(@Param("username") String username);
	
	//查找所有用户
	@Select("select *from sysuser")
	public List<SysUser> findAll();
	
	//添加用户
	@Insert("insert into sysuser(username,password,role) value(#{username},#{password},#{role})")
	public void addUser(SysUser user);
	
	//分页查询用户
	@Select("select id,username,REPLACE(password, SUBSTR(password,4,4), 'XXXX') as password,role from sysuser limit #{page},#{limit} ")
	public List<SysUser> limitFind(PageLimit pageLimit);
	
	//根据用户名查找用户
	@Select("select *from #{username}")
	public SysUser findName(String username);
	
	//登录后根据用户名修改
	@Update("update sysuser set password=#{password} where username=#{username}")
	public SysUser changePass(@Param("password")String password,@Param("username")String username);
	
	
	@Select("delete from sysuser where id=#{id}")
	public void deleteUser(int id);
	
	@Select("select count(*) from sysuser")
	public int getCount();
	@Update("update sysuser set username=#{username},password=#{password},role=#{role} where id=#{id}")
	public void updateUser(SysUser user);
	
	@Select("select id from sysuser where id=#{id}")
	public int getID(SysUser user);
	
	@Select("select * from sysuser where id=#{id}")
	public SysUser getUserById(int id);
	
	//
	@Insert("insert deinfouser(id,username,password,role) value(#{id},#{username},#{password},#{role})")
	public void setInsertDelete(SysUser user);
	
	//
	@Select("select id,username,REPLACE(password, SUBSTR(password,4,4), 'XXXX') as password,role from sysuser where username like #{sysUser.username}  and role like #{sysUser.role} limit #{pageLimit.page},#{pageLimit.limit}")
	public List<SysUser> findUserList(@Param("sysUser") SysUser sysUser,@Param("pageLimit")PageLimit pageLimit);
	
	
}
