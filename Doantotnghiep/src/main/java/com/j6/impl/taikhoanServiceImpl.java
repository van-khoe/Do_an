package com.j6.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.taikhoanDAO;
import com.j6.entity.taikhoan;
import com.j6.service.taikhoanService;

@Service
public class taikhoanServiceImpl implements taikhoanService{
	
	@Autowired
	taikhoanDAO tkDao;

	@Override
	public taikhoan findById(String username) {
		return tkDao.findById(username).get();
	}

	@Override
	public taikhoan save(taikhoan acc) {
		// TODO Auto-generated method stub
		
		return tkDao.save(acc);
	}

}
