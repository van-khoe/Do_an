package com.j6.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "khaibaoyte")
public class khaibaoyte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idkhaibaoyte;
	String hoten;
	String cmnd;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaysinh")
	Date ngaysinh = new Date();
	boolean gioitinh;
	String diachi;
	String bieuhien;
	String tiepxuc;
	boolean khaiho;
	
	@ManyToOne
	@JoinColumn(name = "taikhoan_username")
	taikhoan account;
}
