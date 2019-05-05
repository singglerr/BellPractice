package ru.bellintegrator.singglerr.practice.model;

import javax.persistence.*;

/**
 * Страна
 */
@Entity
@Table(name = "Country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * Служебное поле hibernate
	 */
	@Version
	private Integer version;

	/**
	 * Цифровой код страны
	 */
	@Column(name = "code", length = 3, nullable = false)
	private String code;

	/**
	 * Название страны
	 */
	@Column(name = "name", length = 60, nullable = false)
	private String name;

	/**
	 * Конструктор для hibernate
	 */
	public Country() {

	}

	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
