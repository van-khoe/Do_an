package com.j6.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "vacxin")
public class vacxin implements Serializable {
	@Id
	String idvacxin;
	String tenvacxin;
	String tenhang;
	String tenquocgia;
	Integer thoigianmui2;
	
	@JsonIgnore
	@OneToMany(mappedBy = "vacxin")
	List<dottiem> dottiem;
}
