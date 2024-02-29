package com.watch.rolex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Userregister {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String uname;
	String phoneno;
	String mailid;
	String pword;
	public Userregister() {
		// TODO Auto-generated constructor stub
	}
	public Userregister(int id, String uname, String phoneno, String mailid, String pword) {
		this.id = id;
		this.uname = uname;
		this.phoneno = phoneno;
		this.mailid = mailid;
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
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	@Override
	public String toString() {
		return "Userregister [id=" + id + ", uname=" + uname + ", phoneno=" + phoneno + ", mailid=" + mailid
				+ ", pword=" + pword + "]";
	}
	
	
}
