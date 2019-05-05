package ru.bellintegrator.singglerr.practice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "organization")
	private List<Office> offices;

	public Organization() {
	}

	public Organization(String name, String fullName, String inn, String kpp) {
		this.name = name;
		this.fullName = fullName;
		this.inn = inn;
		this.kpp = kpp;
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

	public List<Office> getOffices() {
		if (offices == null) {
			offices = new ArrayList<>();
		}
		return offices;
	}

	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}

	public void addOffice(Office office) {
		getOffices().add(office);
		office.setOrganization(this);
	}

	public void removeOffice(Office office) {
		getOffices().remove(office);
		office.setOrganization(null);
	}

	public Optional<Office> getMainOffice() {
		Office main = null;
		for (Office office : getOffices()) {
			if (office.getSuperiorOffice() == null) {
				main = office;
				break;
			}
		}
		return Optional.ofNullable(main);
	}

	public void setMainOffice(Office main) {
		for (Office office : getOffices()) {
			if (office == main) {
				office.setSuperiorOffice(null);
			} else {
				office.setSuperiorOffice(main);
			}
		}
	}
}
