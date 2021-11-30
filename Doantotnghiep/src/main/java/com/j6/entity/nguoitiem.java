package com.j6.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")

@Data
@Entity
@Table(name = "nguoitiem")
public class nguoitiem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idnguoitiem;
	@NotBlank(message = "Không để trống họ tên")
//	@Pattern(regexp = "^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)", message = "Họ và tên không đúng định dạng")
	String hoten;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaysinh")
	Date ngaysinh = new Date();
	Boolean gioitinh;
	@NotBlank(message = "Không để trống CMND")
	@Pattern(regexp = "^\\d{12}$", message = "CMND/CCCD phải là số và có 12 chữ số")
	String cmnd;
	@NotBlank(message = "Không để trống tiền sử bệnh")
	String tiensubenh;

	@ManyToOne
	@JoinColumn(name = "taikhoan_username")
	taikhoan account;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dangkytiemchung")
	List<lichsutiem> lichsutiem;
	@JsonIgnore
	@OneToMany(mappedBy = "dangkytiemchung")
	List<phieutiem> phieudangkylichhen;
	
}
