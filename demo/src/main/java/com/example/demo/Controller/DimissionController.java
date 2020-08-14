package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Dimission;
import com.example.demo.Entity.DimissionInfoDe;
import com.example.demo.ServiceInter.DimissionService;
import com.example.demo.ToolEntity.ResultObj;

@Controller
@RequestMapping("dimission")
public class DimissionController {
	@Autowired
	private DimissionService dimissionService;
	
	@RequestMapping("Add")
	@ResponseBody
	public ResultObj addDimission(Dimission dimission) {
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dimission.setDate(sdf.format(new Date()));
			dimissionService.addDimission(dimission);
			return  new ResultObj(200,"添加成功");}
		catch(Exception e) {
			return new ResultObj(-1,"添加失败");
		}
	}
	
	@RequestMapping("Delete")
	@ResponseBody
	public ResultObj deleteDimission(Dimission dimission) {
		try {
			System.out.println(dimission.getId());
			dimissionService.addDeDimission(dimissionService.getDeDimission(dimission.getId()));
			dimissionService.deleteDimission(dimission);
			return  new ResultObj(200,"删除成功");}
		catch(Exception e) {
			return new ResultObj(-1,"删除失败");
		}
	}
	@RequestMapping("DeDelete")
	@ResponseBody
	public ResultObj deleteDeDimission(DimissionInfoDe dimissionInfoDe) {
		try {
			dimissionService.deleteDeDimissionById(dimissionInfoDe.getId());
			return  new ResultObj(200,"删除成功");}
		catch(Exception e) {
			return new ResultObj(-1,"删除失败");
		}
	}
	
	
	@RequestMapping("Update")
	@ResponseBody
	public ResultObj updateDimission(Dimission dimission) {
		try {
			System.out.println(dimission.getId());
			System.out.println(dimission.toString());
			dimissionService.updateDimission(dimission);
			return  new ResultObj(200,"修改成功");}
		catch(Exception e) {
			return new ResultObj(-1,"修改失败");
		}
	}
}
