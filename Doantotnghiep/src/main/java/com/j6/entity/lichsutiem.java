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
@Table(name = "lichsutiem")
public class lichsutiem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idlichsutiem;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaytiem")
	Date ngaytiem = new Date();
	String loso;
	
	@ManyToOne()
	@JoinColumn(name = "dottiem_iddottiem")
	dottiem dottiem;
	@ManyToOne()
	@JoinColumn(name = "nhanvien_idnhanvien")
	nhanvien nhanvien;
	@ManyToOne()
	@JoinColumn(name = "dangkytiemchung_iddangkytiemchung")
	nguoitiem dangkytiemchung;
}
