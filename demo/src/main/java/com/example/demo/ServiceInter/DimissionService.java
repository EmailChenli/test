package com.example.demo.ServiceInter;

import java.util.List;

import com.example.demo.Entity.Dimission;
import com.example.demo.Entity.DimissionInfoDe;
import com.example.demo.ToolEntity.PageLimit;

public interface DimissionService {
	public void addDimission(Dimission dimission);
	public List<Dimission> getListLimit(PageLimit pageLimit);
	public List<Dimission> getListLikeLimit(PageLimit pageLimit,Dimission dimission);
 	public int getCount();
	public Long getDimissionID(Long id);
	public void updateDimission(Dimission dimission);
	public void deleteDimission(Dimission dimission);
	
	//
	public int getDeCount();
	public void deleteDeDimissionById(Long id);
	public void addDeDimission(DimissionInfoDe dimissionInfoDe);
	public DimissionInfoDe getDeDimission(Long id);
	public List<DimissionInfoDe> findDeDimissionLimit(PageLimit pageLimit);
	public void deleteDimissionInfoDe(DimissionInfoDe dimissionInfoDe);
	
}
