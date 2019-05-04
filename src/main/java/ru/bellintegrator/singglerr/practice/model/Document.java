package ru.bellintegrator.singglerr.practice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Document")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Version
	private Integer version;

	@Column(name = "number", length = 50, nullable = false)
	private String number;

	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "is_identified", nullable = false)
	private boolean isIdentified;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private DocType docType;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "document")
	private User user;

	public Document(){

	}

	public Document(String number, Date date, boolean isIdentified, DocType docType) {
		this.number = number;
		this.date = date;
		this.isIdentified = isIdentified;
		this.docType = docType;
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isIdentified() {
		return isIdentified;
	}

	public void setIdentified(boolean identified) {
		isIdentified = identified;
	}

	public DocType getDocType() {
		return docType;
	}

	public void setDocType(DocType docType) {
		this.docType = docType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
