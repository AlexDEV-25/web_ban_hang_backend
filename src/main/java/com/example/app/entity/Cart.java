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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "quantity")
	private int quantity;

	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<CartDetail> cartDetails;

	@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
	private AppUser user;

	public Cart(int quantity, List<CartDetail> cartDetails, AppUser user) {
		this.quantity = quantity;
		this.cartDetails = cartDetails;
		this.user = user;
	}

	public Cart() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public AppUser getAppUser() {
		return user;
	}

	public void setAppUser(AppUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + "]";
	}

}
