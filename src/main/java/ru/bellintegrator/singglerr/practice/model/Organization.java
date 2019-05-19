package ru.bellintegrator.singglerr.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "Organization")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Version
	private Integer version;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "full_name", length = 255, nullable = false)
	private String fullName;

	@Column(name = "inn", length = 12, nullable = false)
	private String inn;

	@Column(name = "kpp", length = 9, nullable = false)
	private String kpp;

	@Column(name = "address", length = 80, nullable = false)
	private String address;

	@Column(name = "phone", length = 20)
	private String phone;

	@Column(name = "is_active")
	private Boolean isActive;

	public Organization() {
	}

	public Organization(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
		this.name = name;
		this.fullName = fullName;
		this.inn = inn;
		this.kpp = kpp;
		this.address = address;
		this.phone = phone;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public String getKpp() {
		return kpp;
	}

	public void setKpp(String kpp) {
		this.kpp = kpp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	@Override
	public String toString() {
		return "{id:" + id + ";name:" + name + ";fullName:" + fullName + ";inn:" + inn + ";kpp:"  + kpp + ";address:" +
				address + ";phone:" + phone + ";isActive:" + isActive + "}";
	}
}
