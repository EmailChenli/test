package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Entity.Entry;
import com.example.demo.ToolEntity.PageLimit;

@Mapper
public interface EntryMapper {
	@Select("select count(*) from entry")
	public int getCount();
	@Select("select id,name,date,REPLACE(phonenumber, SUBSTR(phonenumber,4,4), 'XXXX') as phonenumber,REPLACE(money, SUBSTR(money,1), 'XXXX') as money from entry where name like #{entry.name} and date like #{entry.date} limit #{pageLimit.limit}")
	public List<Entry> getLimitlikeEntry(@Param("entry")Entry entry,@Param("pageLimit")PageLimit pageLimit); 
	
	/*@Select("select id,name,date,REPLACE(phonenumber, SUBSTR(phonenumber,4,4), 'XXXX') as phonenumber,REPLACE(money, SUBSTR(money,1), 'XXXX') as money from entry \r\n" + 
			"where  name like #{entry.name} and date like #{entry.date} limit #{pageLimit.limit}")
	public List<Entry> TestLike(@Param("entry") Entry entry,@Param("pageLimit")PageLimit pageLimit);
	*/
	@Select("select id,name,date,REPLACE(phonenumber, SUBSTR(phonenumber,4,4), 'XXXX') as phonenumber,REPLACE(money, SUBSTR(money,1), 'XXXX') as money from entry  limit #{pageLimit.page},#{pageLimit.limit}")
	public List<Entry> getLimitEntry(@Param("pageLimit")PageLimit pageLimit); 
	
	@Insert("insert into entry(name,date,phonenumber,money) value(#{name},#{date},#{phonenumber},#{money})")
	public void addEntry(Entry entry);
	
	@Update("update entry set name=#{name},date=#{date},phonenumber=#{phonenumber},money=#{money} where id=#{id}")
	public void updateEntry(Entry entry);
	
	@Select("select id from entry where name=#{name}")
	public Long getUesrId(String name);
	
	@Delete("delete from entry where id=#{id}")
	public void deleteEntry(Entry entry);
	
	//
	@Insert("insert into deinfoentry(id,name,date,phonenumber,money) value(#{id},#{name},#{date},#{phonenumber},#{money})")
	public void addEntryInfoDe(Entry entry);
	
	@Select("select*from entry where id=#{id}")
	public Entry getEntryById(Long id);
}
