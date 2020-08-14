package com.example.demo.ServiceInter;

import java.util.List;

import com.example.demo.Entity.Entry;
import com.example.demo.Entity.EntryInfoDe;
import com.example.demo.ToolEntity.PageLimit;

public interface EntryService {
	//入职信息处理
	public int getCount();
	public List<Entry> getEntrylikeList(PageLimit pageLimit,Entry entry);
	public List<Entry> getEntryList(PageLimit pageLimit);
	public void addEntry(Entry entry);
	public void updateEntry(Entry entry);
	public void deleteEntry(Entry entry);
	public Long getEntryId(Entry entry);
	//删除信息
	public Entry getEntryById(Long id);
	public void addEntryInfo(Entry entry);
	public int getDeCount();
	public List<EntryInfoDe> findDeList(PageLimit pageLimit);
	public void entryInfoDelete(Long deEntryInfoDeId);
	public Long getDeId(EntryInfoDe deEntryInfo);
}
