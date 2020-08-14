package com.example.demo.ServiceInterImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Dimission;
import com.example.demo.Entity.DimissionInfoDe;
import com.example.demo.Mapper.DeDimissionMapper;
import com.example.demo.Mapper.DimissionMapper;
import com.example.demo.ServiceInter.DimissionService;
import com.example.demo.ToolEntity.PageLimit;

@Service
public class DimissionServiceImpl implements DimissionService{
	@Autowired
	private DimissionMapper dimissionMapper;
	
	@Autowired
	private DeDimissionMapper deDimissionMapper;
	
	@Override
	public void addDimission(Dimission dimission) {
		// TODO Auto-generated method stub
		dimissionMapper.addDimission(dimission);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dimissionMapper.getCount();
	}
	@Override
	public List<Dimission> getListLimit(PageLimit pageLimit) {
		// TODO Auto-generated method stub
		return dimissionMapper.getlistLimit(pageLimit);
	}
	@Override
	public Long getDimissionID(Long  id) {
		// TODO Auto-generated method stub
		return dimissionMapper.getDimissionId(id);
	}
	@Override
	public void updateDimission(Dimission dimission) {
		// TODO Auto-generated method stub
		dimissionMapper.updateDimission(dimission);
	}
	@Override
	public void deleteDeDimissionById(Long id) {
		// TODO Auto-generated method stub
		deDimissionMapper.deleteById(id);
	}
	
	@Override
	public void deleteDimission(Dimission dimission) {
		// TODO Auto-generated method stub
		dimissionMapper.deleteDimissionById(dimission.getId());
	}
	@Override
	public void addDeDimission(DimissionInfoDe dimissionInfoDe) {
		// TODO Auto-generated method stub
		deDimissionMapper.addDeDimission(dimissionInfoDe);
	}
	@Override
	public List<DimissionInfoDe> findDeDimissionLimit(PageLimit pageLimit) {
		return deDimissionMapper.LimitDimissionInfoDe(pageLimit);
	}
	@Override
	public int getDeCount() {
		// TODO Auto-generated method stub
		return deDimissionMapper.getDeCount();
	}
	@Override
	public DimissionInfoDe getDeDimission(Long id) {
		// TODO Auto-generated method stub
		return deDimissionMapper.getDeDimission(id);
	}
	@Override
	public void deleteDimissionInfoDe(DimissionInfoDe dimissionInfoDe) {
		// TODO Auto-generated method stub
		deDimissionMapper.deleteById(dimissionInfoDe.getId());
	}
	@Override
	public List<Dimission> getListLikeLimit(PageLimit pageLimit, Dimission dimission) {
		// TODO Auto-generated method stub
		return dimissionMapper.getlistLikeLimit(pageLimit, dimission);
	}
	
}
