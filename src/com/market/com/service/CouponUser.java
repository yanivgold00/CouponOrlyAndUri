package com.market.com.service;

import java.sql.SQLException;

public class CouponUser implements DBobject {
	private String username;
	private String userpass;
	private CouponGroup group;
	/**
	 * @return the username
	 */
	
	public CouponUser(){
		
	}
	
	public CouponUser(String username, String userpass, int group) throws SQLException {
		super();
		this.username = username;
		this.userpass = userpass;
		this.setGroup(group);
		
	}

	public CouponUser(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the userpass
	 */
	public String getUserpass() {
		return userpass;
	}
	/**
	 * @param userpass the userpass to set
	 */
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	/**
	 * @return the group
	 */
	public CouponGroup getGroup() {
		return group;
	}
	/**
	 * @param group the group to set
	 * @throws SQLException 
	 */
	public void setGroup(int group) throws SQLException {
		CouponGroup tmp = new CouponGroup();
		tmp.setGroupnum(group);
		tmp.getByID();
		this.group = tmp;
	}

	@Override
	public void save() throws SQLException {
		String query = "INSERT INTO makolet.couponuser VALUES ('%s','%s',%d)";
		query = String.format(query, this.username,this.userpass,this.group.getGroupnum());
		System.out.println(query);
		SQLHandler.execute(query);
		
	}

	@Override
	public void getByID() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

/*
 * CREATE TABLE `makolet`.`couponuser` (
  `username` VARCHAR(10) NOT NULL,
  `userpassword` VARCHAR(30) NOT NULL,
  `groupid` INT NOT NULL,
  PRIMARY KEY (`username`),
  INDEX `groupid_idx` (`groupid` ASC),
  CONSTRAINT `groupID`
    FOREIGN KEY (`groupid`)
    REFERENCES `makolet`.`coupongroup` (`groupID`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);
*/
