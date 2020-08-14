package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Entity.Dimission;
import com.example.demo.ToolEntity.PageLimit;

@Mapper
public interface DimissionMapper {
	@Insert("insert into dimission(name,date,phonenumber,money) value(#{name},#{date},#{phonenumber},#{money})")
	public void addDimission(Dimission dimission);
	
	@Select("select id,name,date,REPLACE(phonenumber, SUBSTR(phonenumber,4,4), 'XXXX') as phonenumber,REPLACE(money, SUBSTR(money,1), 'XXXX') as money from dimission limit #{page},#{limit}")
	public List<Dimission> getlistLimit(PageLimit pageLimit);
	
	@Select("select id,name,date,REPLACE(phonenumber, SUBSTR(phonenumber,4,4), 'XXXX') as phonenumber,REPLACE(money, SUBSTR(money,1), 'XXXX') as money from dimission where name like #{dimission.name} and date like #{dimission.date} limit #{pageLimit.limit}")
	public List<Dimission> getlistLikeLimit(@Param("pageLimit")PageLimit pageLimit,@Param("dimission")Dimission dimission);
	
	@Select("select count(*) from dimission")
	public int  getCount();
	
	@Select("select id from dimission where id=#{id}")
	public Long getDimissionId(Long id);
	
	@Delete("delete from dimission where id=#{id}")
	public void deleteDimissionById(Long id);
	
	
	@Update("update dimission set name=#{name},date=#{date},phonenumber=#{phonenumber},money=#{money} where id=#{id}")
	public void updateDimission(Dimission dimission);
}
