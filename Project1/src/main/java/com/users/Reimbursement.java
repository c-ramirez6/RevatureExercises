package com.users;

public class Reimbursement {
	private int id;
	private int users_id;
	private double amount;
	private String type;
	private String desc;
	private String date;
	private String status;
	
	public Reimbursement()	{
		
	}

	public Reimbursement(int id, int users_id, double amount, String type, String desc, String date, String status) {
		super();
		this.id = id;
		this.users_id = users_id;
		this.amount = amount;
		this.type = type;
		this.desc = desc;
		this.date = date;
		this.status = status;
	}
	
	public Reimbursement(int users_id, double amount, String type, String desc, String date) {
		super();
		this.users_id = users_id;
		this.amount = amount;
		this.type = type;
		this.desc = desc;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", users_id=" + users_id + ", amount=" + amount + ", type=" + type
				+ ", desc=" + desc + ", date=" + date + ", status=" + status + "]";
	}
	
	
}
