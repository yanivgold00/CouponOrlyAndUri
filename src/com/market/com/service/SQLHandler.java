package com.market.com.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

public class SQLHandler {
	public static String db_address="localhost";
	public static String db_name="marketdb";
	public static String db_user="root";
	public static String db_pass="pass";
	
	public static Connection conn;
	public static void connect2DB (){
		getConnection(db_address, db_name,db_user, db_pass);
	}
	public static void getConnection(String address,String db_name, String username, String password){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + address+"/"+db_name, username,password);
//			conn.setAutoCommit(false);
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeConnetion(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void execute(String sql) throws SQLException{
		connect2DB();
		Statement statement = null;
		try{
		 statement = conn.createStatement();
		 System.out.println(sql);
		 statement.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		closeConnetion();
	}

	public static ResultSet run_query(String sql){
		connect2DB();
		ResultSet res = null;
		try{
		Statement statement = conn.createStatement();
		System.out.println(sql);
		res = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static void add(String stmt) throws SQLException {
		String stmtadd = stmt;
		execute(stmtadd);
	}
	
	
	
	public static void delete(String table, String id) {
		String stmt = null;
		
		try {
			
			
			switch(table) {
				case  "company":// stmt += "; DELETE FROM company_coupon WHERE COMP_ID=" + id;
					stmt = "SELECT * FROM company_coupon WHERE COMP_ID=" + id;
					ResultSet coupons = run_query(stmt);
					stmt = "";
					if(coupons != null) {
						
						while(coupons.next()) {
							stmt = "DELETE FROM coupon WHERE ID=\"" + coupons.getString(2) + "\"; ";
							execute(stmt);
							stmt = "DELETE FROM customer_coupon WHERE COUPON_ID=\"" + coupons.getString(2) + "\"; ";
							execute(stmt);
							stmt = "DELETE FROM company_coupon WHERE COMP_ID=\"" + id + "\"; ";
							execute(stmt);
						}
						
					}
					break;
				case "customer": stmt = "DELETE FROM customer_coupon WHERE CUST_ID=" + id + "; ";
					execute(stmt);
					break;
				case "coupon": stmt = "";
					stmt = "DELETE FROM customer_coupon WHERE COUPON_ID=\"" + id + "\"; ";
					execute(stmt);
					stmt = "DELETE FROM company_coupon WHERE COUPON_ID=\"" + id + "\"; ";
					execute(stmt);
					break;
			}
			stmt = "DELETE FROM " + table + " WHERE ID=" + id;
			execute(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
	}
	
	public static Collection<Coupon> getAllCoupons(String table, String id){
		connect2DB();
		String sql = "SELECT COUPON_ID FROM " + table + " WHERE " + table.substring(0, 4).toUpperCase() + "_ID=\"" + id+"\"";
		ResultSet idList =  run_query(sql);
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			while(idList.next()) {
				try{
					sql = "SELECT * FROM coupon WHERE ID=\"" + idList.getString(1)+"\"";
					Statement statement = conn.createStatement();
					ResultSet res = statement.executeQuery(sql);
					if(res.next()) {
						Coupon coup = new Coupon(idList.getString(1), res.getString(2), (Date)res.getObject(3), (Date)res.getObject(4), res.getInt(5), res.getString(6), res.getString(7), res.getDouble(8), res.getString(9));
						list.add(coup);
					}
				} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnetion();
		return (Collection<Coupon>)list;
	}
	
	public static Collection<Coupon> getAllCouponsByPrice(String table, String id, double price){
		connect2DB();
		String sql = "SELECT COUPON_ID FROM " + table + " WHERE " + table.substring(0, 4).toUpperCase() + "_ID=" + id;
		ResultSet idList =  run_query(sql);
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			while(idList.next()) {
				try{
					sql = "SELECT * FROM coupon WHERE ID=" + idList.getString(1) + " AND PRICE<=" + price;
					Statement statement = conn.createStatement();
					ResultSet res = statement.executeQuery(sql);
					if(res.next()) {
						Coupon coup = new Coupon(idList.getString(1), res.getString(2), (Date)res.getObject(3), (Date)res.getObject(4), res.getInt(5), res.getString(6), res.getString(7), res.getDouble(8), res.getString(9));
						list.add(coup);
					}
				} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnetion();
		return (Collection<Coupon>)list;
	}
	
	public static Collection<Coupon> getAllCouponsByType(String table, String id, CouponType type){
		connect2DB();
		String sql = "SELECT COUPON_ID FROM " + table + " WHERE " + table.substring(0, 4).toUpperCase() + "_ID=" + id;
		ResultSet idList = run_query(sql);
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			while(idList.next()) {
				try{
					sql = "SELECT * FROM coupon WHERE ID=" + idList.getString(1) + " AND TYPE=\"" + type+"\"";
					Statement statement = conn.createStatement();
					ResultSet res = statement.executeQuery(sql);
					if(res.next()) {
						Coupon coup = new Coupon(idList.getString(1), res.getString(2), (Date)res.getObject(3), (Date)res.getObject(4), res.getInt(5), res.getString(6), res.getString(7), res.getDouble(8), res.getString(9));
						list.add(coup);
					}
				} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnetion();
		return (Collection<Coupon>)list;
	}
	
	public static Collection<Coupon> getAllCouponsByDate(String table, String id, Date endDate){
		connect2DB();
		String sql = "SELECT COUPON_ID FROM " + table + " WHERE " + table.substring(0, 4).toUpperCase() + "_ID=" + id;
		ResultSet idList = run_query(sql);
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			while(idList.next()) {
				try{
	
					sql = "SELECT * FROM coupon WHERE ID=" + idList.getString(1)+";";
					Statement statement = conn.createStatement();
					ResultSet res = statement.executeQuery(sql);
					if(res.next() && res.getDate(4).before(endDate)) {
						System.out.println(res.getDate(4) + " < " + endDate);
						Coupon coup = new Coupon(idList.getString(1), res.getString(2), (Date)res.getObject(3), (Date)res.getObject(4), res.getInt(5), res.getString(6), res.getString(7), res.getDouble(8), res.getString(9));
						list.add(coup);
					}
				} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnetion();
		return (Collection<Coupon>)list;
	}

	public static void addCoupon(ClientType clientType, Coupon coupon, String id) {
		connect2DB();
		String stmt = null;
		if (clientType == ClientType.Company) {
			stmt = "INSERT INTO coupon VALUES (\"" + coupon.getId() + "\", \"" + coupon.getTitle() + "\", \"" + coupon.getStartDate() + "\", \"" 
					+ coupon.getEndDate() + "\", \"" + coupon.getAmount() + "\", \"" + coupon.getType() + "\", \"" + coupon.getMessage() + "\", \"" + coupon.getPrice() + "\", \"" + coupon.getImage() +"\")";
			try {
				execute(stmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = "INSERT INTO company_coupon VALUES (\"" + id + "\", \"" + coupon.getId() + "\")";
			try {
				execute(stmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (clientType == ClientType.Customer) {
			stmt = "INSERT INTO customer_coupon VALUES (\"" + id + "\", \"" + coupon.getId() + "\")";
			try {
				execute(stmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		closeConnetion();
		
	}
	
}
