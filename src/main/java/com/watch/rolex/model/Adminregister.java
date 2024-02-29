package com.watch.rolex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adminregister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String uname;
	String pword;
	public Adminregister() {
		// TODO Auto-generated constructor stub
	}
	public Adminregister(int id, String uname,String pword) {
		this.id = id;
		this.uname = uname;
		this.pword = pword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	@Override
	public String toString() {
		return "Adminregister [id=" + id + ", uname=" + uname + ", pword=" + pword + "]";
	}
}
