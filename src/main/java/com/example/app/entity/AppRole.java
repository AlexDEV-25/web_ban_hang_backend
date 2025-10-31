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
@Table(name = "role")
public class AppRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "role_name")
	private String roleName;

	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	public List<AppUser> users;

	public AppRole(String roleName, List<AppUser> users) {
		this.roleName = roleName;
		this.users = users;
	}

	public AppRole() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<AppUser> getAppUser() {
		return users;
	}

	public void setAppUser(List<AppUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "AppRole [id=" + id + ", roleName=" + roleName + "]";
	}

}
