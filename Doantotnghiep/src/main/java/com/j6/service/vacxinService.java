package com.j6.service;

import java.util.List;

import com.j6.entity.vacxin;

public interface vacxinService {


	List<vacxin> findAll();

	vacxin create(vacxin vacxin);

	vacxin update(vacxin vacxin);

	void delete(String id);

}
