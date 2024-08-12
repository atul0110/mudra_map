package com.mudra.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "costumer_info")
public class CostumerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long costumer_info_id;
	private String name;
	private String mobile_no;
	private String address;
	private String profile_img;
	private String created_at;
	private String is_deleted;

	public CostumerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CostumerInfo(long costumer_info_id, String name, String mobile_no, String address, String profile_img,
			String created_at, String is_deleted) {
		super();
		this.costumer_info_id = costumer_info_id;
		this.name = name;
		this.mobile_no = mobile_no;
		this.address = address;
		this.profile_img = profile_img;
		this.created_at = created_at;
		this.is_deleted = is_deleted;
	}

	public long getCostumer_info_id() {
		return costumer_info_id;
	}

	public void setCostumer_info_id(long costumer_info_id) {
		this.costumer_info_id = costumer_info_id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}

}
