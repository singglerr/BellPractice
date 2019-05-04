package ru.bellintegrator.singglerr.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "Country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Version
	private Integer version;

	@Column(name = "code", nullable = false)
	private int code;

	@Column(name = "name", length = 60, nullable = false)
	private String name;

	public Country() {

	}

	public Country(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
