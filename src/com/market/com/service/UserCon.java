package com.market.com.service;

public class UserCon {

		String name;
		String password;
		boolean isLogin;
		int num;
		
		
		public UserCon(String username, String pass) {
			// TODO Auto-generated constructor stub
		}
		public void User(String name, String password) {
		//	super();
			this.name = name;
			this.password = password;
			this.isLogin = checklogin();
			this.num = (int)(Math.random()*1000000);
		}
		private boolean checklogin() {
			if(this.password != null && this.password.length() >4)
				return true;
			return false;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @return the isLogin
		 */
		public boolean isLogin() {
			return isLogin;
		}
		
		/**
		 * @return the num
		 */
		public int getNum() {
			return num;
		}
		/**
		 * @param isLogin the isLogin to set
		 */
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "User [name=" + name + ", password=" + password + ", isLogin=" + isLogin + "]";
		}
		
		
		
	}//end class


