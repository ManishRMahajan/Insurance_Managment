package com.test.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Claim {

	@Id
	@Column(name = "Claim_number")
	private int claimNumber;

	@Column(name = "Descdription")
	private String Descdription;

	@Column(name = "Date")
	private Date date;

	@Column(name = "Claim_Status")
	private String claimStatus;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "insurance_id")
	InsurancePolicy insurancePolicy;

	public int getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getDescdription() {
		return Descdription;
	}

	public void setDescdription(String descdription) {
		Descdription = descdription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}

}
