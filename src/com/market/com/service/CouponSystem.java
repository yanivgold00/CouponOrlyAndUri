package com.market.com.service;

public class CouponSystem {
	private final static CouponSystem INSTANCE = new CouponSystem();
	private DailyCouponExpirationTask task;
	
	 public CouponSystem() {
		// TODO Auto-generated constructor stub
	}

	public static CouponSystem getInstance() {
		return INSTANCE;
	}
}
