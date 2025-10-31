package com.example.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "star")
	private int star;

	@Column(name = "content", length = 256)
	private int content;

	@Column(name = "hide")
	private boolean hide;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "user_id", nullable = false)
	private AppUser user;

	public Review(int star, int content, boolean hide, Product product, AppUser user) {
		this.star = star;
		this.content = content;
		this.hide = hide;
		this.product = product;
		this.user = user;
	}

	public Review() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public boolean getHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public AppUser getAppUser() {
		return user;
	}

	public void setAppUser(AppUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", star=" + star + ", content=" + content + ", hide=" + hide + "]";
	}
}
