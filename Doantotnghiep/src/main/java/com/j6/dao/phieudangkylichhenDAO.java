package com.j6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.j6.entity.phieutiem;

public interface phieudangkylichhenDAO extends JpaRepository<phieutiem, Long>{
	@Query("SELECT o FROM phieutiem o WHERE o.dangkytiemchung.account.username=?1")
	List<phieutiem> findByAccount(String username);

}
