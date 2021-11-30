package com.j6.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j6.entity.vacxin;
import com.j6.service.vacxinService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/vaccine")
public class LoaiVaccineRestCotroller {
	@Autowired
	vacxinService vacxinservice;
	
	@GetMapping
	public List<vacxin> getAll() {
		return vacxinservice.findAll();
	}
	
	@PostMapping
	public vacxin create(@RequestBody vacxin vacxin) {
		return vacxinservice.create(vacxin);
	}
	
	@PutMapping("{idvacxin}")
	public vacxin update(@PathVariable("idvacxin") String id,@RequestBody vacxin vacxin) {
		return vacxinservice.update(vacxin);
	}
	
	@DeleteMapping("{idvacxin}")
	public void update(@PathVariable("idvacxin") String id) {
		vacxinservice.delete(id);
	}
}
