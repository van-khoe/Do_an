package com.j6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	

	@RequestMapping({"/", "/home/index"})
	public String home(Model model) {
	
		return "redirect:/home";
	}
	
	@RequestMapping({"/admin","/admin/home/index"})
	public String admin() {
		return "redirect:/assert/admin/index.html";
	}
	
	
}
