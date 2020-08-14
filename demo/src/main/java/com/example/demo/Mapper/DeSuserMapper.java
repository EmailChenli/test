package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Entity.SysUserInfoDe;
import com.example.demo.ToolEntity.PageLimit;

@Mapper
public interface DeSuserMapper {
	@Delete("delete from deinfouser where id=#{id}")
	public void deleteByDeSuser(Long id);
	
	@Select("select id from deinfouser where id=#{id}")
	public int getDeId(SysUserInfoDe deUser);
	@Select("select id,username,REPLACE(password, SUBSTR(password,4,4), 'XXXX') as password,role from deinfouser  limit  #{page},#{limit}")
	public List<SysUserInfoDe> selectAllDeSuser(PageLimit pageLimit);
	
	@Select("select count(*) from deinfouser")
	public int getDeCount();
	
}
