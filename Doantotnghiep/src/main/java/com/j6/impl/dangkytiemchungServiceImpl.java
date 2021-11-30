package com.j6.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.dangkytiemchungDAO;
import com.j6.entity.nguoitiem;
import com.j6.service.dangkytiemchungService;

@Service
public class dangkytiemchungServiceImpl implements dangkytiemchungService{
	@Autowired
	dangkytiemchungDAO dangkyDAO;

	@Override
	public nguoitiem save(nguoitiem dk) {
		// TODO Auto-generated method stub
		return dangkyDAO.save(dk);
	}

}
