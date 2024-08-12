package com.mudra.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_costumer_info")
public class UserCostumerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_costumer_info_id;
	private long user_info_id;
	private long costumer_info_id;

	public UserCostumerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCostumerInfo(long user_costumer_info_id, long user_info_id, long costumer_info_id) {
		super();
		this.user_costumer_info_id = user_costumer_info_id;
		this.user_info_id = user_info_id;
		this.costumer_info_id = costumer_info_id;
	}

	public long getUser_costumer_info_id() {
		return user_costumer_info_id;
	}

	public void setUser_costumer_info_id(long user_costumer_info_id) {
		this.user_costumer_info_id = user_costumer_info_id;
	}

	public long getUser_info_id() {
		return user_info_id;
	}

	public void setUser_info_id(long user_info_id) {
		this.user_info_id = user_info_id;
	}

	public long getCostumer_info_id() {
		return costumer_info_id;
	}

	public void setCostumer_info_id(long costumer_info_id) {
		this.costumer_info_id = costumer_info_id;
	}

}
