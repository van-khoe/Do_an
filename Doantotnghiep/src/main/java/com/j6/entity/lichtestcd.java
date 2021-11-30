package com.j6.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "lichtestcd")
public class lichtestcd implements Serializable {
	@Id
	int idlichtestcd;
	Date ngaytest;
	int soluongnguoitest;
	int mauamtinh;
	int mauduongtinh;

	@ManyToOne()
	@JoinColumn(name = "diaphuong_iddiaphuong")
	diaphuong diaphuong;
}
