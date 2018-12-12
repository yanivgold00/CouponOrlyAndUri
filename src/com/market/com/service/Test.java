package com.market.com.service;


	import java.sql.Date;
import java.util.ArrayList;
	import java.util.Collection;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;

	import com.market.com.service.UserCon;
	import com.market.com.service.Coupon;
	import com.market.com.service.SQLHandler;
	import com.market.com.service.AdminFacade;
	import com.market.com.service.ClientType;
	import com.market.com.service.Company;
	import com.market.com.service.Customer;
	import com.market.com.service.CouponType;
	import com.market.com.service.CouponClientFacade;
	import com.market.com.service.CouponUser;
	import com.market.com.service.CustomerFacade;
	import com.market.com.service.CompanyFacade;
	import com.market.com.service.DBobject;

	public class Test {

		public static void main(String[] args) {

			AdminFacade user = (AdminFacade) CouponClientFacade.login("admin", "1234", ClientType.Admin);
		
			Company company_1 = new Company("1", "home Center", "hc8888", "homecenter@gmail.com",null);
			Coupon coupon = new Coupon("1", "coupon", Date.valueOf("2000-12-4"), Date.valueOf("2099-12-4"), 100, "electricity", "a coupon", 105, null);
			
			System.out.println(company_1);
			Customer customer_1= new Customer ("1","moshe", "moshe123",null);
			System.out.println(customer_1);
			
			user.removeCompany(company_1);
			
			user.createCompany(company_1);
			
			// ***createCompany
//			 user.createCompany(company_9);

			//***getCompany 
			 Company company_4; 
			 company_4 = user.getCompany("1"); 
			 System.out.println(company_4);
			 
			 company_4.setCompName("Home center 2");

			// ***updateCompany
			 user.updateCompany(company_4);
			// user.updateCompany(company_5);
			// user.updateCompany(company_7);
			// user.updateCompany(company_8);

			
			 //***getCompany 
			 company_4 = user.getCompany("1"); 
			 System.out.println(company_4);
			 

			// ***getAllCompany
			 Collection<Company> company = user.getAllCompanys();
			 System.out.println(company);

			// ***login
			CompanyFacade comp = (CompanyFacade) CouponClientFacade.login("Home center 2", "hc8888",ClientType.Company);
			 if(comp != null){ System.out.println("OK"); }
			 else { System.out.println("wrong"); }
			 
			 comp.removeCoupon(coupon);
			 
			 comp.createCoupon(coupon);
			 
			// ***getCoupons
			 Collection<Coupon> coupons = comp.getAllCoupons();
			 System.out.println(coupons);
			 
			 System.out.println("--------");
			 
			 coupons = comp.getCouponByType(CouponType.electricity);
			 System.out.println(coupons);
			 
			 System.out.println("--------");
			 
			 coupons = comp.getCouponByType(CouponType.food);
			 System.out.println(coupons);
			 
			 System.out.println("--------");
			 
			 coupons = comp.getCouponByPrice(200.0);
			 System.out.println(coupons);
			 
			 System.out.println("--------");
			 
			 coupons = comp.getCouponByDate(Date.valueOf("2099-12-4"));
			 System.out.println(coupons);

			 System.out.println("--------");
			 
			 coupons = comp.getCouponByDate(Date.valueOf("2039-12-4"));
			 System.out.println(coupons);
			 
			// ***removeCompany
			 //user.removeCompany(company_4);

			// --------------------------------------------------------
			// --------------------------------------------------------

			 user.removeCustomer(customer_1);
				
				user.createCustomer(customer_1);
				
				// ***createCompany
//				 user.createCompany(company_9);

				//***getCompany 
				 Customer customer_4; 
				 customer_4 = user.getCustomer("1"); 
				 System.out.println(customer_4);
				 
				 customer_4.setCustName("Moshe");

				// ***updateCustomer
				 user.updateCustomer(customer_4);
				// user.updateCompany(company_5);
				// user.updateCompany(company_7);
				// user.updateCompany(company_8);

				
				 //***getCustomer 
				 customer_4 = user.getCustomer("1"); 
				 System.out.println(customer_4);
				 

				// ***getAllCustomer
				 Collection<Customer> customer = user.getAllCustomers();
				 System.out.println(customer);

				// ***login
				CustomerFacade cust = (CustomerFacade) CouponClientFacade.login("Moshe", "moshe123",ClientType.Customer);
				 if(cust != null){ System.out.println("OK"); }
				 else { System.out.println("wrong"); }
				 
				 
				 cust.purchaseCoupon(coupon);
				 
				// ***getCoupons
				 Collection<Coupon> coupons2 = cust.getAllPurchasedCoupons();
				 System.out.println(coupons2);
				 
				 System.out.println("--------");
				 
				 coupons2 = cust.getAllPurchasedCouponsbyType(CouponType.electricity);
				 System.out.println(coupons2);
				 
				 System.out.println("--------");
				 
				 coupons2 = cust.getAllPurchasedCouponsbyType(CouponType.food);
				 System.out.println(coupons2);
				 
				 System.out.println("--------");
				 
				 coupons2 = cust.getAllPurchasedCouponsbyPrice(200.0);
				 System.out.println(coupons2);
				 
				 
		}

	}


