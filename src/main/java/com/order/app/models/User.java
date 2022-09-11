package com.order.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reg_id;
	@Override
	public String toString() {
		return "User [reg_id=" + reg_id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int reg_id, String firstname, String lastname) {
		super();
		this.reg_id = reg_id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public int getReg_id() {
		return reg_id;
	}
	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	private String firstname;
	private String lastname;
	
}
