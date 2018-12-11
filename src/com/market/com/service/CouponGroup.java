package com.market.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CouponGroup implements DBobject{
	private int groupnum;
	private String groupName;
	
	public CouponGroup(){
		
	}

	public CouponGroup(int groupnum, String groupName) {
		super();
		this.groupnum = groupnum;
		this.groupName = groupName;
	}

	/**
	 * @return the groupnum
	 */
	public int getGroupnum() {
		return groupnum;
	}

	/**
	 * @param groupnum the groupnum to set
	 */
	public void setGroupnum(int groupnum) {
		this.groupnum = groupnum;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CouponGroup [groupnum=" + groupnum + ", groupName=" + groupName + "]";
	}

	@Override
	public void save() throws SQLException {
		String query = "INSERT INTO makolet.coupongroup VALUES ('%d','%s')";
		query = String.format(query, this.groupnum, this.groupName);
		System.out.println(query);
		SQLHandler.execute(query);
		
	}
	
	@Override
	public void getByID() throws SQLException {
		String query  =String.format( 
				"SELECT groupName FROM makolet.coupongroup WHERE groupID= '%d';",this.groupnum);
		SQLHandler.connect2DB();
		ResultSet res = SQLHandler.run_query(query);
		if (res.next()){
			this.groupName = res.getNString(1);
		}
		SQLHandler.closeConnetion();
		
		
		
	}
	
	public static CouponGroup[] getAllGroups() throws SQLException{
		String query = "SELECT * FROM MAKOLET.coupongroup;";
		SQLHandler.connect2DB();
		ResultSet res = SQLHandler.run_query(query);
//		int size = res.getFetchSize();
		CouponGroup[] couponGroups = new CouponGroup[100];
		int i=0;
		while(res.next()){
			CouponGroup tmp = new CouponGroup(res.getInt(1), res.getString(2));
			System.out.println(tmp);
			couponGroups[i]= tmp;
			i++;
		}
		
		SQLHandler.closeConnetion();
		return couponGroups;
	}
	
}
/*
CREATE TABLE `coupongroup` (
`groupID` INT NOT NULL,
`groupName` VARCHAR(10) NOT NULL,
`CouponGroupcol` VARCHAR(45) NULL,
PRIMARY KEY (`groupID`));
*/

/*
 * INSERT INTO makolet.coupongroup VALUES ('301','user');
 * */
 