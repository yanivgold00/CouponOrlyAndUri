package com.market.com.service;

import java.util.Collection;
import java.sql.Date;
//TODO add login
public class CompanyFacade extends CouponClientFacade {
	Company company;
	//TODO add create
	public CompanyFacade(Company company) {
		super();
		// TODO Auto-generated constructor stub
		this.company = company;
	}

	public void createCoupon(Coupon coupon) {
		SQLHandler.addCoupon(ClientType.Company, coupon, company.getId());
	}

	public void removeCoupon(Coupon coupon) {
		SQLHandler.delete("coupon", company.getId());
	}

	//TODO add function
	public void updateCoupon(Coupon coupon) {
		
	}

	//TODO add function
//	public Coupon getCoupon(String id) {
//		
//	}

	public Collection<Coupon> getAllCoupons() {
		return SQLHandler.getAllCoupons("company_coupon", company.getId());
	}

	public Collection<Coupon> getCouponByType(CouponType type) {
		return SQLHandler.getAllCouponsByType("company_coupon", company.getId(), type);
	}

	public Collection<Coupon> getCouponByPrice(Double price) {
		return SQLHandler.getAllCouponsByPrice("company_coupon", company.getId(), price);
	}

	public Collection<Coupon> getCouponByDate(Date endDate) {
		return SQLHandler.getAllCouponsByDate("company_coupon", company.getId(), endDate);
	}

	

}
