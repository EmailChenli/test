package com.example.demo.ServiceInterImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.SysUser;
import com.example.demo.Entity.SysUserInfoDe;
import com.example.demo.Mapper.DeSuserMapper;
import com.example.demo.Mapper.SuserMapper;
import com.example.demo.ServiceInter.UserService;
import com.example.demo.ToolEntity.PageLimit;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private SuserMapper suserMapper;
	
	@Autowired
	private DeSuserMapper deSuserMapper;
	
	@Override
	public SysUser userlogin(SysUser user) {
		// TODO Auto-generated method stub
		return suserMapper.findUser(user);
	}

	@Override
	public List<SysUser> findAll() {
		// TODO Auto-generated method stub
		return suserMapper.findAll();
	}

	@Override
	public void addUser(SysUser user) {
		// TODO Auto-generated method stub
		suserMapper.addUser(user);
	}

	@Override
	public List<SysUser> findList(PageLimit pageLimit) {
		// TODO Auto-generated method stub
		return suserMapper.limitFind(pageLimit);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return suserMapper.getCount();
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		suserMapper.deleteUser(userId);
	}

	@Override
	public void updateUser(SysUser user) {
		// TODO Auto-generated method stub
		suserMapper.updateUser(user);
	}

	@Override
	public int getId(SysUser user) {
		// TODO Auto-generated method stub
		suserMapper.getID(user);
		return suserMapper.getID(user);
	}

	@Override
	public SysUser getUserById(int userId) {
		// TODO Auto-generated method stub
		return suserMapper.getUserById(userId);
	}

	@Override
	public void deUserInfo(SysUser user) {
		// TODO Auto-generated method stub
		
		 suserMapper.setInsertDelete(user);
	}

	@Override
	public List<SysUserInfoDe> findDeList(PageLimit pageLimit) {
		// TODO Auto-generated method stub
		return deSuserMapper.selectAllDeSuser(pageLimit);
	}

	@Override
	public int getDeCount() {
		// TODO Auto-generated method stub
		return deSuserMapper.getDeCount();
	}

	@Override
	public void deUserDelete(Long deuserId) {
		// TODO Auto-generated method stub
		deSuserMapper.deleteByDeSuser(deuserId);
	}

	@Override
	public int getDeId(SysUserInfoDe deUser) {
		// TODO Auto-generated method stub
		return deSuserMapper.getDeId(deUser);
	}

	@Override
	public List<SysUser> findLikeList(SysUser sysUser,PageLimit pageLimit) {
		// TODO Auto-generated method stub
		return suserMapper.findUserList(sysUser, pageLimit);
	}

	@Override
	public SysUser changePass(String password, String username) {
		// TODO Auto-generated method stub
		return suserMapper.changePass(password, username);
	}

	@Override
	public String getRole(String username) {
		// TODO Auto-generated method stub
		return suserMapper.getRole(username);
	}

}
