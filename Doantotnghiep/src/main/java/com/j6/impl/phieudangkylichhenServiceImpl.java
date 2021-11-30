package com.j6.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.phieudangkylichhenDAO;
import com.j6.entity.phieutiem;
import com.j6.service.phieudangkylichhenService;

@Service
public class phieudangkylichhenServiceImpl implements phieudangkylichhenService{
	@Autowired
	phieudangkylichhenDAO phieutiemDAO;

	@Override
	public List<phieutiem> findAll() {
		// TODO Auto-generated method stub
		return phieutiemDAO.findAll();
	}

	@Override
	public phieutiem create(phieutiem phieutiem) {
		// TODO Auto-generated method stub
		return phieutiemDAO.save(phieutiem);
	}

	@Override
	public phieutiem update(phieutiem phieutiem) {
		// TODO Auto-generated method stub
		return phieutiemDAO.save(phieutiem);
	}

	@Override
	public void delete(Long id) {
		phieutiemDAO.deleteById(id);
		
	}

	@Override
	public List<phieutiem> findByAccount(String username) {
		// TODO Auto-generated method stub
		return phieutiemDAO.findByAccount(username);
	}

	@Override
	public phieutiem findById(Long id) {
		// TODO Auto-generated method stub
		return phieutiemDAO.findById(id).get();
	}

}
