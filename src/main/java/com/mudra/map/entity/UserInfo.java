package com.mudra.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_info_id;
	private String name;
	private String mobile_no;
	private String password;
	private String created_at;
	private String status;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(long user_info_id, String name, String mobile_no, String password, String created_at,
			String status) {
		super();
		this.user_info_id = user_info_id;
		this.name = name;
		this.mobile_no = mobile_no;
		this.password = password;
		this.created_at = created_at;
		this.status = status;
	}

	public long getUser_info_id() {
		return user_info_id;
	}

	public void setUser_info_id(long user_info_id) {
		this.user_info_id = user_info_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
