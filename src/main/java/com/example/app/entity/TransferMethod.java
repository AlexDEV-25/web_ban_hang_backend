package com.example.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "transfer_method")
public class TransferMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "transfer_method_name")
	private String transferMethodName;

	@Column(name = "description")
	private String description;

	@Column(name = "hide")
	private boolean hide;

	@OneToMany(mappedBy = "transferMethod", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Bill> bills;

	public TransferMethod(String transferMethodName, String description, boolean hide, List<Bill> bills) {
		this.transferMethodName = transferMethodName;
		this.description = description;
		this.hide = hide;
		this.bills = bills;
	}

	public TransferMethod() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransferMethodName() {
		return transferMethodName;
	}

	public void setTransferMethodName(String transferMethodName) {
		this.transferMethodName = transferMethodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	@Override
	public String toString() {
		return "TransferMethod [id=" + id + ", transferMethodName=" + transferMethodName + ", description="
				+ description + ", hide=" + hide + "]";
	}
}
