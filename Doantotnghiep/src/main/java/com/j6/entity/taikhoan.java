package com.j6.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "taikhoan")
public class taikhoan implements Serializable {

	@Id
	@NotBlank(message = "Không để trống tài khoản")
	String username;
	@NotBlank(message = "Không để trống họ và tên")
	String hoten;
	@NotBlank(message = "Không để trống mật khẩu")
	@Pattern(regexp="^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$",message = "Mật khẩu không đúng định dạng")
	String matkhau;
	@NotBlank(message = "Không để trống địa chỉ")
	String diachi;
	@NotNull(message = "Chọn giới tính")
	Boolean gioitinh;
	@NotBlank(message = "Không để trống số điện thoại")
	@Pattern(regexp="^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",message="Số điện thoại không đúng định dạng")  
	String sdt;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaysinh")
	Date ngaysinh = new Date();
	@NotNull(message = "Tùy chọn trạng thái tài khoản")
	Boolean trangthai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<khaibaoyte> khaibaoyte;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<nguoitiem> dangkytiemchung;
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<capquyen> capquyen;
}
