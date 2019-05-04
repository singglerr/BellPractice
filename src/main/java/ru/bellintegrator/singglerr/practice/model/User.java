package ru.bellintegrator.singglerr.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Version
	private Integer version;

	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "second_name", length = 50)
	private String secondName;

	@Column(name = "middle_name", length = 50)
	private String middleName;

	@Column(name = "phone", length = 20)
	private String phone;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "doc_id", unique = true)
	private Document document;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "office_id")
	private Office office;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id")
	private Position position;

	public User() {
	}

	public User(String firstName, String secondName, String middleName, String phone, Document document, Office office,
				Country country, Position position) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.middleName = middleName;
		this.phone = phone;
		this.document = document;
		this.office = office;
		this.country = country;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
