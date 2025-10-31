package com.example.app.entity;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "status")
	private int status;

	@Column(name = "total")
	private double total;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "user_id", nullable = false)
	private AppUser user;

	@OneToMany(mappedBy = "bill", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<BillDetail> billDetails;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "payment_method_id", nullable = false)
	private PaymentMethod paymentMethod;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "transfer_method_id", nullable = false)
	private TransferMethod transferMethod;

	public Bill(Date startDate, Date endDate, int status, double total, AppUser user, List<BillDetail> billDetails,
			PaymentMethod paymentMethod, TransferMethod transferMethod) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.total = total;
		this.user = user;
		this.billDetails = billDetails;
		this.paymentMethod = paymentMethod;
		this.transferMethod = transferMethod;
	}

	public Bill() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public AppUser getAppUser() {
		return user;
	}

	public void setAppUser(AppUser user) {
		this.user = user;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public TransferMethod getTransferMethod() {
		return transferMethod;
	}

	public void setTransferMethod(TransferMethod transferMethod) {
		this.transferMethod = transferMethod;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status
				+ ", total=" + total + "]";
	}
}
