package com.market.com.service;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class AdminFacade extends CouponClientFacade {

	public AdminFacade() {
		super();
		// TODO Auto-generated constructor stub
	}
	//TODO add body
	public void createCompany(Company company) {
		String stmt = "INSERT INTO company VALUES (\"" + company.getId() + "\", \"" + company.getCompName() + "\", \"" + company.getPassword() + "\", \"" 
				+ company.getEmail() + "\")";
		try {
			SQLHandler.add(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeCompany(Company company) {
		SQLHandler.delete("company", company.getId());
	}

	//TODO add body
	public void updateCompany(Company company) {
		String stmt = "UPDATE company SET COMP_NAME = \"" + company.getCompName() + "\", PASSWORD = \"" 
	+ company.getPassword() + "\", EMAIL = \"" + company.getEmail() + "\" WHERE ID=\"" + company.getId() + "\"";
		try {
			SQLHandler.add(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TODO add body
	public Company getCompany(String id) {
		ResultSet comp= SQLHandler.run_query("SELECT * FROM company WHERE ID=" + id);
		try {
			comp.next();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Company company = null;
		try {
			company = new Company(comp.getString("ID"), comp.getString("COMP_NAME"), comp.getString("PASSWORD"), comp.getString("EMAIL"),new ArrayList());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return company;
	}
	
	//TODO add body
	public Collection<Company> getAllCompanys() {
		ResultSet comp= SQLHandler.run_query("SELECT * FROM company;");
		ArrayList<Company> companys = new ArrayList();
		try {
			while(comp.next()) {
				companys.add(new Company(comp.getString("ID"), comp.getString("COMP_NAME"), comp.getString("PASSWORD"), comp.getString("EMAIL"),null));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return companys;
		
	}
	
	//TODO add body
	public void createCustomer(Customer customer) {

	}

	public void removeCustomer(Customer customer) {
		SQLHandler.delete("customer", customer.getId());
	}
	
	//TODO add body
	public void updateCustomer(Customer customer) {

	}
	
	
	//TODO add body
//	public Customer getCustomer(String id) {
//		
//	}
	
	//TODO add body
//	public Collection<Customer> getAllCustomers() {
//		
//	}


}
