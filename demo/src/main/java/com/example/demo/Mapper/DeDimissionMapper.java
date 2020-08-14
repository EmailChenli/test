package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Entity.DimissionInfoDe;
import com.example.demo.ToolEntity.PageLimit;

@Mapper
public interface DeDimissionMapper {
	@Insert("insert deinfodimission(id,name,date,phonenumber,money) value(#{id},#{name},#{date},#{phonenumber},#{money})")
	public void addDeDimission(DimissionInfoDe dimissionInfoDe);
	
	
	@Select("select *from dimission where id=#{id}")
	public DimissionInfoDe getDeDimission(Long id);
	
	
	@Delete("delete from deinfodimission where id=#{id}")
	public void deleteById(Long id);
	
	@Select("select id,name,date,REPLACE(phonenumber, SUBSTR(phonenumber,4,4), 'XXXX') as phonenumber,REPLACE(money, SUBSTR(money,1), 'XXXX') as money from deinfodimission  limit  #{page},#{limit}")
	public List<DimissionInfoDe> LimitDimissionInfoDe(PageLimit pageLimit);
	
	@Select("select count(*) from deinfodimission")
	public int getDeCount();
}
