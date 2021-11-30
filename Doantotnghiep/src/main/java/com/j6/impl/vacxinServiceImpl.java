package com.j6.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.vacxinDAO;
import com.j6.entity.vacxin;
import com.j6.service.vacxinService;

@Service
public class vacxinServiceImpl implements vacxinService{
	@Autowired
	vacxinDAO vacDAO;
	
	@Override
	public List<vacxin> findAll() {
		// TODO Auto-generated method stub
		return vacDAO.findAll();
	}
	@Override
	public vacxin create(vacxin vacxin) {
		// TODO Auto-generated method stub
		return vacDAO.save(vacxin);
	}
	@Override
	public vacxin update(vacxin vacxin) {
		// TODO Auto-generated method stub
		return vacDAO.save(vacxin);
	}
	@Override
	public void delete(String id) {
		vacDAO.deleteById(id);
		
	}

}
