package com.example.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "thumbnail")
public class Thumbnail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "thumbnail_name", length = 256)
	private String thumbnailName;

	@Column(name = "icon")
	private boolean icon;

	@Column(name = "link")
	private String link;

	@Column(name = "data")
	@Lob
	private String data;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	public Thumbnail(String thumbnailName, boolean icon, String link, String data) {
		this.thumbnailName = thumbnailName;
		this.icon = icon;
		this.link = link;
		this.data = data;
	}

	public Thumbnail() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getThumbnailName() {
		return thumbnailName;
	}

	public void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}

	public boolean isIcon() {
		return icon;
	}

	public void setIcon(boolean icon) {
		this.icon = icon;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Thumbnail [id=" + id + ", thumbnailName=" + thumbnailName + ", icon=" + icon + ", link=" + link
				+ ", data=" + data + "]";
	}
}
