package com.market.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CouponClientFacade {
	
	public static CouponClientFacade login(String name,String  pass, ClientType clientType) {
		if(clientType == ClientType.Admin) {
			if(name == "admin" && pass == "1234") {
				return new AdminFacade();
			}
		}
		else if(clientType == ClientType.Company) {
			SQLHandler.connect2DB();
			String temp_pass = "";
			try {
				ResultSet user= SQLHandler.run_query("SELECT PASSWORD FROM company WHERE COMP_NAME=\"" + name+"\""); 
				
				if(user.next()) {
					
					temp_pass = user.getString(1);
					System.out.println(temp_pass);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(temp_pass.equals(pass)) {
				ResultSet comp= SQLHandler.run_query("SELECT * FROM company WHERE COMP_NAME=\"" + name+"\"");
				try {
					comp.next();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Company company = new Company(comp.getString("ID"), comp.getString("COMP_NAME"), comp.getString("PASSWORD"), comp.getString("EMAIL"),null);
					return new CompanyFacade(company);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println(pass + "wrong pass "+temp_pass);
			}
		}
		else if(clientType == ClientType.Customer) {
			SQLHandler.connect2DB();
			String temp_pass = "";
			try {
				temp_pass =SQLHandler.run_query("SELECT PASSWORD FROM customer WHERE CUST_NAME=" + name).getString(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(temp_pass == pass) {
				ResultSet cust= SQLHandler.run_query("SELECT * FROM customer WHERE CUST_NAME=" + name);
				try {
					Customer customer = new Customer(cust.getString("ID"), cust.getString("CUST_NAME"), cust.getString("PASSWORD"), null);
					return new CustomerFacade(customer);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		return null;
	}

}
