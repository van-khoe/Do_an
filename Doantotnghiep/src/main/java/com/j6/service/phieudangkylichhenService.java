package com.j6.service;

import java.util.List;

import com.j6.entity.phieutiem;

public interface phieudangkylichhenService {

	List<phieutiem> findAll();

	phieutiem create(phieutiem phieutiem);

	phieutiem update(phieutiem phieutiem);

	void delete(Long id);

	List<phieutiem> findByAccount(String username);

	phieutiem findById(Long id);

}
