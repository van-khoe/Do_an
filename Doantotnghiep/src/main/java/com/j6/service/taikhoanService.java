package com.j6.service;

import com.j6.entity.taikhoan;

public interface taikhoanService {

	taikhoan findById(String username);

	taikhoan save(taikhoan acc);

}
