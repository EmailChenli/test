package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Entry;
import com.example.demo.Entity.EntryInfoDe;
import com.example.demo.ServiceInter.EntryService;
import com.example.demo.ToolEntity.ResultObj;

@Controller
@RequestMapping("entry")
public class EntryController {
	@Autowired
	private EntryService entryService;
	
	@RequestMapping("Add")
	@ResponseBody
	public ResultObj addEntry(Entry entry) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			entry.setDate(sdf.format(new Date()));
		    entryService.addEntry(entry);
		    return new ResultObj(200,"添加成功");
		}catch(Exception e) {
			return new ResultObj(-1,"添加失败");
		}
	}
	
	@RequestMapping("Update")
	@ResponseBody
	public ResultObj updateEntry(Entry entry) {
		try {
			entry.setId(entryService.getEntryId(entry));
			System.out.println(entry.toString());
		    entryService.updateEntry(entry);
		    return new ResultObj(200,"修改成功");
		}catch(Exception e) {
			return new ResultObj(-1,"修改失败");
		}
	}
	
	@RequestMapping("Delete")
	@ResponseBody
	public ResultObj deleteEntry(Entry entry) {
		try {
			System.out.println(entry.getId());
			entryService.addEntryInfo(entryService.getEntryById(entry.getId()));
		    entryService.deleteEntry(entry);
		    return new ResultObj(200,"删除成功");
		}catch(Exception e) {
			return new ResultObj(-1,"删除失败");
		}
	}
	
	@RequestMapping("DeDelete")
	@ResponseBody
	public ResultObj deleteDeEntry(EntryInfoDe entryInfoDe) {
		try {
			System.out.println(entryInfoDe.getId());
			entryService.entryInfoDelete(entryInfoDe.getId());
		    return new ResultObj(200,"删除成功");
		}catch(Exception e) {
			return new ResultObj(-1,"删除失败");
		}
	}
}

