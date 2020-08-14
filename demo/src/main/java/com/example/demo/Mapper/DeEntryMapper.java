package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Entity.EntryInfoDe;
import com.example.demo.ToolEntity.PageLimit;

@Mapper
public interface DeEntryMapper {
	
	@Delete("delete from deinfoentry where id=#{id}")
	public void deleteByEntryInfoDeId(Long id);
	
	@Select("select id from deinfoentry where id=#{id}")
	public Long getEntryInfoDeId(EntryInfoDe deEntry);
	@Select("select id,name,date,REPLACE(phonenumber, SUBSTR(phonenumber,4,4), 'XXXX') as phonenumber,REPLACE(money, SUBSTR(money,1), 'XXXX') as money from deinfodimission where id order by id asc limit #{page},#{limit}")
	public List<EntryInfoDe> LimitEntryInfoDe(PageLimit pageLimit);
	
	@Select("select count(*) from deinfoentry")
	public int getEntryInfoDeCount();
}
