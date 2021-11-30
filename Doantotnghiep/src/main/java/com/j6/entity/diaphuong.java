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
@Table(name = "diaphuong")
public class diaphuong implements Serializable {
	@Id
	int iddiaphuong;
	String tinh;
	String huyen;
	String xa;
	@JsonIgnore
	@OneToMany(mappedBy = "diaphuong")
	List<lichtestcd> lichtestcd;
}
