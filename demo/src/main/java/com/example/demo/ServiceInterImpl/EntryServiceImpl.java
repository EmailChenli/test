package com.example.demo.ServiceInterImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Entry;
import com.example.demo.Entity.EntryInfoDe;
import com.example.demo.Mapper.DeEntryMapper;
import com.example.demo.Mapper.EntryMapper;
import com.example.demo.ServiceInter.EntryService;
import com.example.demo.ToolEntity.PageLimit;

@Service
public class EntryServiceImpl implements EntryService{
	@Autowired
	private EntryMapper entryMapper;
	
	@Autowired
	private DeEntryMapper deEntryMapper;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return entryMapper.getCount();
	}

	@Override
	public List<Entry> getEntryList(PageLimit pageLimit) {
		// TODO Auto-generated method stub
		return entryMapper.getLimitEntry(pageLimit);
	}

	@Override
	public void addEntry(Entry entry) {
		// TODO Auto-generated method stub
		entryMapper.addEntry(entry);
	}

	@Override
	public void updateEntry(Entry entry) {
		// TODO Auto-generated method stub
		entryMapper.updateEntry(entry);
	}

	@Override
	public void deleteEntry(Entry entry) {
		// TODO Auto-generated method stub
		entryMapper.deleteEntry(entry);
	}

	@Override
	public Long getEntryId(Entry entry) {
		// TODO Auto-generated method stub
		return entryMapper.getUesrId(entry.getName());
	}

	@Override
	public int getDeCount() {
		// TODO Auto-generated method stub
		return deEntryMapper.getEntryInfoDeCount();
	}

	@Override
	public List<EntryInfoDe> findDeList(PageLimit pageLimit) {
		// TODO Auto-generated method stub
		return deEntryMapper.LimitEntryInfoDe(pageLimit);
	}

	@Override
	public void entryInfoDelete(Long deEntryInfoDeId) {
		// TODO Auto-generated method stub
		deEntryMapper.deleteByEntryInfoDeId(deEntryInfoDeId);
	}

	@Override
	public Long getDeId(EntryInfoDe deEntryInfo) {
		// TODO Auto-generated method stub
		return deEntryMapper.getEntryInfoDeId(deEntryInfo);
	}

	@Override
	public void addEntryInfo(Entry entry) {
		// TODO Auto-generated method stub
		entryMapper.addEntryInfoDe(entry);
	}

	@Override
	public Entry getEntryById(Long id) {
		// TODO Auto-generated method stub
		return entryMapper.getEntryById(id);
	}

	@Override
	public List<Entry> getEntrylikeList(PageLimit pageLimit, Entry entry) {
		// TODO Auto-generated method stub
		/*System.out.println(entry.toString());
		System.out.println(entryMapper.TestLike(entry,pageLimit).toString());*/
		return entryMapper.getLimitlikeEntry(entry, pageLimit);
	}

}
