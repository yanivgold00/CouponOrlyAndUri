package com.market.com.service;

public class DailyCouponExpirationTask implements Runnable {
	private boolean quit;
	public DailyCouponExpirationTask() {
		super();
		// TODO Auto-generated constructor stub
		this.quit = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!this.quit) {
			
		}
		
	}
	
	public void stopTask() {
		this.quit = true;
	}

}
