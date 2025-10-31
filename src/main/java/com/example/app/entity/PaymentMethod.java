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
@Table(name = "payment_method")
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "payment_method_name")
	private String paymentMethodName;

	@Column(name = "description")
	private String description;

	@Column(name = "hide")
	private boolean hide;

	@OneToMany(mappedBy = "paymentMethod", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Bill> bills;

	public PaymentMethod(String paymentMethodName, String description, boolean hide, List<Bill> bills) {
		this.paymentMethodName = paymentMethodName;
		this.description = description;
		this.hide = hide;
		this.bills = bills;
	}

	public PaymentMethod() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public boolean getHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	@Override
	public String toString() {
		return "PaymentMethod [id=" + id + ", paymentMethodName=" + paymentMethodName + ", description=" + description
				+ ", hide=" + hide + "]";
	}
}
