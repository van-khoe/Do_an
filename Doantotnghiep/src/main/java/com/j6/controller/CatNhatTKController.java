package com.j6.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.j6.entity.taikhoan;
import com.j6.service.taikhoanService;

@Controller
public class CatNhatTKController {
	@Autowired
	taikhoanService taikhoanS;

	@Autowired
	HttpServletRequest rq;
	
	@GetMapping("/taikhoan/capnhat")
	public String capnhat(Model model) {
		String id = rq.getRemoteUser();
		taikhoan account = taikhoanS.findById(id);
		model.addAttribute("acc", account);
		model.addAttribute("home", true);
		return "security/capnhattk";
	}
	@PostMapping("/taikhoan/capnhat")
	public String capnhat1(Model model,@Validated @ModelAttribute("acc") taikhoan acc, Errors err) {
		try {
//			if(err.getFieldError().getField().equals("matkhau") && err.getFieldError().getField().equals("trangthai")) {
			if(err.getErrorCount() <= 2) {	
			String id = rq.getRemoteUser();
				taikhoan account = taikhoanS.findById(id);
				acc.setMatkhau(account.getMatkhau());
				acc.setTrangthai(account.getTrangthai());
				taikhoanS.save(acc);
			}else{
					System.out.println(err.getAllErrors());
				System.out.println(acc.getNgaysinh());
				model.addAttribute("message", "Vui lòng sửa các lỗi");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message","Cập nhật thất bại");
		}
		model.addAttribute("home", true);
		return "security/capnhattk";
	}
}
