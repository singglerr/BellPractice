package ru.bellintegrator.singglerr.practice.model;


import javax.persistence.*;

@Entity
@Table(name = "Doc_type")
public class DocType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Version
	private Integer version;

	@Column(name = "code", length = 2, nullable = false)
	private String code;

	@Column(name = "name", length = 128, nullable = false)
	private String name;

	public DocType(){

	}

	public DocType(String code, String name){
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
