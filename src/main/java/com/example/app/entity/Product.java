package com.example.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "product_code", length = 256)
	private String productCode;

	@Column(name = "product_name", length = 256)
	private String productName;

	@Column(name = "description", columnDefinition = "text")
	private String description;

	@Column(name = "product_image", length = 256)
	private String productImage;

	@Column(name = "price_origin")
	private Double priceOrigin;

	@Column(name = "price")
	private Double price;

	@Column(name = "amount")
	private int amount;

	@Column(name = "sold")
	private int sold;

	@Column(name = "hide")
	private boolean hide;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<ProductCategoty> categories;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Thumbnail> thumbnails;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Review> reviews;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<BillDetail> billDetail;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<CartDetail> cartDetail;

	public Product(long id, String productCode, String productName, String description, String productImage,
			Double priceOrigin, Double price, int amount, int sold, boolean hide, List<ProductCategoty> categories,
			List<Thumbnail> thumbnails, List<Review> reviews, List<BillDetail> billDetail,
			List<CartDetail> cartDetail) {
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.description = description;
		this.productImage = productImage;
		this.priceOrigin = priceOrigin;
		this.price = price;
		this.amount = amount;
		this.sold = sold;
		this.hide = hide;
		this.categories = categories;
		this.thumbnails = thumbnails;
		this.reviews = reviews;
		this.billDetail = billDetail;
		this.cartDetail = cartDetail;
	}

	public Product() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Double getPriceOrigin() {
		return priceOrigin;
	}

	public void setPriceOrigin(Double priceOrigin) {
		this.priceOrigin = priceOrigin;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public boolean getHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	public List<ProductCategoty> getCategories() {
		return categories;
	}

	public void setCategories(List<ProductCategoty> categories) {
		this.categories = categories;
	}

	public List<Thumbnail> getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(List<Thumbnail> thumbnails) {
		this.thumbnails = thumbnails;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<BillDetail> getBillDetail() {
		return billDetail;
	}

	public void setBillDetail(List<BillDetail> billDetail) {
		this.billDetail = billDetail;
	}

	public List<CartDetail> getCartDetail() {
		return cartDetail;
	}

	public void setCartDetail(List<CartDetail> cartDetail) {
		this.cartDetail = cartDetail;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productCode=" + productCode + ", productName=" + productName + ", description="
				+ description + ", priceOrigin=" + priceOrigin + ", price=" + price + ", amount=" + amount + ", sold="
				+ sold + ", hide=" + hide + "]";
	}
}
