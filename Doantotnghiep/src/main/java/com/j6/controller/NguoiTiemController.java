package com.j6.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.j6.entity.nguoitiem;
import com.j6.entity.phieutiem;
import com.j6.entity.taikhoan;
import com.j6.entity.vacxin;
import com.j6.service.dangkytiemchungService;
import com.j6.service.phieudangkylichhenService;
import com.j6.service.taikhoanService;
import com.j6.service.vacxinService;

@Controller
public class NguoiTiemController {
	
	@Autowired
	HttpServletRequest rq;
	@Autowired
	taikhoanService taikhoanS;
	@Autowired
	dangkytiemchungService dangkyS;
	@Autowired
	vacxinService vacS;
	@Autowired
	phieudangkylichhenService lichhenS;
	
	@RequestMapping("/lichhentiemchung")
	public String phieutiem(Model model) {
		String id = rq.getRemoteUser();
		taikhoan account = taikhoanS.findById(id);
		List<phieutiem> pt = lichhenS.findByAccount(account.getUsername());
		model.addAttribute("pt", pt);
		model.addAttribute("home", true);
		return "tiemchung/lichhentiemchung";
	}
	@RequestMapping("/chitietlichtiem")
	public String phieutiem1(@RequestParam("idphieu") Long id,Model model) {
		String ida = rq.getRemoteUser();
		taikhoan account = taikhoanS.findById(ida);
		List<phieutiem> pt = lichhenS.findByAccount(account.getUsername());
		for(phieutiem p : pt){
			if(p.getIdphieutiem().equals(id) ) {
				phieutiem phieutiem = lichhenS.findById(id);
				model.addAttribute("phieutiem", phieutiem);
				model.addAttribute("home", true);
				return "tiemchung/chitietlichtiem";
			}
		}
		
		return "tiemchung/lichhentiemchung";
	}
	
	@GetMapping("/dangkytiemchung")
	public String home1(Model model) {
		
		nguoitiem dk = new nguoitiem();
		dk.setGioitinh(true);
		model.addAttribute("dk", dk);
		
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		String max = formatter.format(new Date());
//		model.addAttribute("max", new Date("2021/11/28"));
//		System.out.println(max);
		model.addAttribute("home", true);
		return "tiemchung/dangkytiemchung";
	}
	
	@PostMapping("/dangkytiemchung")
	public String home1n(Model model,@Validated @ModelAttribute("dk") nguoitiem dk, Errors err) {
		try {
			String id = rq.getRemoteUser();
			taikhoan account = taikhoanS.findById(id);

			dk.setAccount(account);
			if(!err.hasErrors()) {
				dangkyS.save(dk);
				model.addAttribute("message", "Thành công");
			}
			else {
				System.out.println(err.getAllErrors());
				model.addAttribute("message", "Thất bại");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		model.addAttribute("home", true);
		return "tiemchung/dangkytiemchung";
	}
	
	@RequestMapping("/nhacnhotiemchung")
	public String home2(Model model) {
		model.addAttribute("home", true);
		return "tiemchung/nhacnhotiemchung";
	}
}
