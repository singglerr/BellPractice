package ru.bellintegrator.singglerr.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "Position")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Version
	private Integer version;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	public Position() {

	}

	public Position(String name) {
		this.name = name;
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
}
