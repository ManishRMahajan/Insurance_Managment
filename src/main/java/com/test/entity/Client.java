package com.test.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Date_of_Birth")
	private Date dateOfBirth;

	@Column(name = "Address")
	private String address;

	@Column(name = "Contact_Information")
	private String contactInformation;

	@ManyToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<InsurancePolicy> insurancepolicy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public List<InsurancePolicy> getInsurancepolicy() {
		return insurancepolicy;
	}

	public void setInsurancepolicy(List<InsurancePolicy> insurancepolicy) {
		this.insurancepolicy = insurancepolicy;
	}

}
