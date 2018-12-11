package com.market.com.service;

import java.util.Collection;
//TODO add login
public class CustomerFacade extends CouponClientFacade {
	Customer customer;
	public CustomerFacade(Customer customer) {
		super();
		// TODO Auto-generated constructor stub
		this.customer = customer;
	}

	public void purchaseCoupon(Coupon coupon) {
		SQLHandler.addCoupon(ClientType.Customer, coupon, customer.getId());
	}

	public Collection<Coupon> getAllPurchasedCoupons() {
		return SQLHandler.getAllCoupons("customer_coupon", customer.getId());

	}

	public Collection<Coupon> getAllPurchasedCouponsbyType(CouponType couponType) {
		return SQLHandler.getAllCouponsByType("customer_coupon", customer.getId(), couponType);
	}

	public Collection<Coupon> getAllPurchasedCouponsbyPrice(double price) {
		return SQLHandler.getAllCouponsByPrice("customer_coupon", customer.getId(), price);
	}

	

}
