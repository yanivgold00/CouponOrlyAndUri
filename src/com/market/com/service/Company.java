package com.market.com.service;

import java.sql.SQLException;
import java.util.Collection;

public class Company {
	private String id;
	private String compName;
	private String password;
	private String email;
	private Collection<Coupon> coupons;

	public Company(String id, String compName, String password, String email, Collection<Coupon> coupons) {
		this.id = id;
		this.compName = compName;
		this.password = password;
		this.email = email;
		this.coupons = coupons;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Collection<Coupon> coupons) {
		this.coupons = coupons;
	}
	
   

	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", password=" + password + ", email=" + email
				+ ", coupons=" + coupons + "]" ;
	}
	
	 public  void Addcompany(String stat) throws SQLException {
			
			stat =  "insert into marketdb.company(id,comp_name,password,email) values ("+id+","+compName+","+password+","+email+")";
			System.out.println(stat);
			SQLHandler.execute(stat);
		}

}
