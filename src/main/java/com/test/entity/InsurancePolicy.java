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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Insurance_Policy")
public class InsurancePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int insuranceId;

	@Column(name = "Policy_Number")
	private String policyNumber;

	@Column(name = "Type")
	private String type;

	@Column(name = "Coverage_Amount")
	private long coverageAmount;

	@Column(name = "Premium")
	private String premium;

	@Column(name = "Start_Date")
	private Date startDate;

	@Column(name = "End_Date")
	private Date endDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "Client_id")
	private List<Client> client;

	@OneToOne(mappedBy = "insurancePolicy", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Claim claim;

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(long coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

}
