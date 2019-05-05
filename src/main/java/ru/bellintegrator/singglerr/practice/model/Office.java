package ru.bellintegrator.singglerr.practice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Office")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Version
	private Integer version;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "address", length = 80, nullable = false)
	private String address;

	@Column(name = "phone", length = 20)
	private String phone;

	@Column(name = "is_active", nullable = false)
	private boolean isActive;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "org_id")
	private Organization organization;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "superior_id")
	private Office superiorOffice;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "office")
	private List<User> users;

	public Office() {
	}

	public Office(String name, String address, String phone, boolean isActive, Organization organization,
				  Office superiorOffice) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.isActive = isActive;
		this.organization = organization;
		this.superiorOffice = superiorOffice;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Office getSuperiorOffice() {
		return superiorOffice;
	}

	public void setSuperiorOffice(Office superiorOffice) {
		this.superiorOffice = superiorOffice;
	}

	public List<User> getUsers() {
		if (users == null){
			users = new ArrayList<>();
		}
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addUser(User user){
		getUsers().add(user);
		user.setOffice(this);
	}

	public void removeUser(User user){
		getUsers().remove(user);
		user.setOffice(null);
	}
}
