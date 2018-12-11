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

			// Customeruser user2 = new Customeruser();
		
			

			// ***createCustomer
			// user2.createCustomer(customer_2);
			// user2.createCustomer(customer_3);
			// user2.createCustomer(customer_4);
			// user2.createCustomer(customer_5);

			// ***removeCustomer
			// user2.removeCustomer(5);

			// ***updateCustomer
			// user2.updateCustomer(customer_4);

			// ***getCompany
			// Customer customer_4 = new Customer();
			// customer_4= user2.getCustomer(4);
			// System.out.println(customer_4);

			// ***getAllCustomers
			// List<Customer> customer = user2.getAllCustomer();
			// System.out.println(customer);

			// ***login
			/*
			 * if(user2.login("moshe", "moshe123")){ System.out.println("OK"); } else
			 * { System.out.println("wrong"); }
			 */

			// --------------------------------------------------------
			// --------------------------------------------------------

			// Couponuser user3= new Couponuser();
			// Coupon coupon_5= new Coupon("dessert", "1.1.2017", "1.12.2017", 30,
			// "FOOD", null, 20, null, 8);
			// Coupon coupon_5= new Coupon(9,"dessert", "1.1.2017", "1.12.2017", 30,
			// "FOOD", null, 20, null, 8);
			// Coupon coupon_5= new Coupon( "tent", "1.1.2017", "31.12.2017", 30,
			// "CAMPING", null, 1999, null, 8);

			// ***createCoupon
			// user3.createCoupon(coupon_5);

			// ***removeCoupon
			// user3.removeCoupon(10);

			// ***updateCoupon
			// user3.updateCoupon(coupon_5);

			// ***getAllCustomers
			// List<Coupon> coupon = user3.getAllCoupon();
			// System.out.println(coupon);

			// ***getCouponById
			// Coupon coupon_4 = new Coupon();
			// coupon_4= user3.getCoupon(4);
			// System.out.println(coupon_4);

			// ***getCouponByCompanyId
			// List<Coupon> coupon = user3.getCouponByCompanyId(7);
			// System.out.println(coupon);

			// ***getCouponByCustomerId
			// List<Coupon> coupon2 = user3.getCouponByCustomerId(3);
			// System.out.println(coupon2);

			// ***getCouponByType
			// List<Coupon> coupon =user3.getCouponByType(CouponType.CAMPING);
			// System.out.println(coupon);

			// --------------------------------------------------------
			// --------------------------------------------------------

			// L     OOOOO GGGGG III  CCCCC
			// L     O   O G      I  C
			// L     O   O G GG   I  C
			// LLLLL OOOOO GGGGG III  CCCCC

			/////////////////////////////////////////////////////////////////
			// COUPON LOGIC TESTER
			/////////////////////////////////////////////////////////////////

			// ***create coupon
			/*
			 * CouponLogic couponLogic=new CouponLogic(); try {
			 * couponLogic.createCoupon( "flashlight", "1.1.2017", "31.12.2017", 30,
			 * "CAMPING", null, 1999, null, 8); } catch (ApplicationException e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); }
			 */

			// ***remove coupon
			/*
			 * CouponLogic couponLogic=new CouponLogic(); try {
			 * couponLogic.removeCoupon(19); } catch (ApplicationException e) {
			 * e.printStackTrace(); }
			 */

			// ***update coupon
			/*
			 * CouponLogic couponLogic=new CouponLogic(); try { Coupon coupon = new
			 * Coupon(9, "flashlight", "1.1.2017", "31.12.2017", -40, "CAMPING",
			 * null, 1999, null, 8); couponLogic.updateCoupon(coupon); } catch
			 * (ApplicationException e) { e.printStackTrace(); }
			 */

			// ***get coupon by id

			/*
			 * CouponLogic couponLogic = new CouponLogic(); try { Coupon coupon_111
			 * = new Coupon(); coupon_111 = couponLogic.getCoupon(9);
			 * System.out.println(coupon_111);
			 * 
			 * } catch (ApplicationException e) { e.printStackTrace(); }
			 */

			// ***get coupon by company id

			/*
			 * CouponLogic couponLogic = new CouponLogic(); List<Coupon>
			 * allCouponByCompanyId = new ArrayList<>(); try { allCouponByCompanyId
			 * = couponLogic.getCouponByCompanyId(8); } catch (ApplicationException
			 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
			 * System.out.println(allCouponByCompanyId);
			 */

			// ***get coupon by company id

			/*
			 * CouponLogic couponLogic = new CouponLogic(); List<Coupon>
			 * allCouponByCoustomerId = new ArrayList<>(); try {
			 * allCouponByCoustomerId = couponLogic.getCouponByCustomerId(1); }
			 * catch (ApplicationException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } System.out.println(allCouponByCoustomerId);
			 */

			// ***get coupon by company id

			/*
			 * CouponLogic couponLogic = new CouponLogic(); List<Coupon> allCoupons
			 * = new ArrayList<>(); try { allCoupons = couponLogic.getAllCoupon(); }
			 * catch (ApplicationException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } System.out.println(allCoupons);
			 */

			// ***get coupon by company id

			/*
			 * CouponLogic couponLogic = new CouponLogic(); List<Coupon>
			 * allCouponByType = new ArrayList<>(); try { allCouponByType =
			 * couponLogic.getCouponByType(CouponType.CAMPING); } catch
			 * (ApplicationException e) { // TODO Auto-generated catch bloc
			 * e.printStackTrace(); } System.out.println(allCouponByType);
			 */

			/////////////////////////////////////////////////////////////////
			// CASTOMER LOGIC TESTER
			/////////////////////////////////////////////////////////////////

			// ***create castomer

			/*
			 * CustomerLogic customerLogic = new CustomerLogic(); try {
			 * customerLogic.createCustomer(customer_11); } catch
			 * (ApplicationException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

			// ***remove castomer

			/*
			 * CustomerLogic customerLogic = new CustomerLogic(); try {
			 * customerLogic.removeCustomer(5); } catch (ApplicationException e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); }
			 */

			// ***update castomer

			/*
			 * CustomerLogic customerLogic = new CustomerLogic(); try { Customer
			 * customer = new Customer(4, "natali", "natali2525");
			 * customerLogic.updateCustomer(customer_4); } catch
			 * (ApplicationException e) { e.printStackTrace(); }
			 */

			// ***get customery

			/*
			 * CustomerLogic customerLogic = new CustomerLogic(); try { Customer
			 * customer_222 = new Customer(); customer_222 =
			 * customerLogic.getCustomer(2); System.out.println(customer_222);
			 * 
			 * } catch (ApplicationException e) { e.printStackTrace(); }
			 */

			// ***get all castomers

			/*
			 * CustomerLogic customerLogic = new CustomerLogic(); List<Customer>
			 * allCustomers = new ArrayList<>(); try { allCustomers
			 * =customerLogic.getAllCustomer(); } catch (ApplicationException e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); }
			 * System.out.println(allCustomers);
			 */

			// ***login

			/*
			 * CustomerLogic customerLogic = new CustomerLogic(); try { String
			 * cust_name = null; String password = null;
			 * customerLogic.login(cust_name, password); } catch
			 * (ApplicationException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

			/////////////////////////////////////////////////////////////////
			// COMPANY LOGIC TESTER
			/////////////////////////////////////////////////////////////////

			// ***create company
			/*
			 * CompanyLogic logic = new CompanyLogic(); try {
			 * logic.createCompany(company_12);System.out.println("login succeeded"
			 * ); } catch (ApplicationException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); }
			 */

			// ***remove company

			/*
			 * CompanyLogic logic = new CompanyLogic(); try {
			 * logic.removeCompany(11); } catch (ApplicationException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } }
			 */

			// ***update company

			/*
			 * CompanyLogic companyLogic = new CompanyLogic(); try { Company company
			 * = new Company(9, "fast food", "ff9898", "fast_food@gmail.com");
			 * companyLogic.updateCompany(company); } catch (ApplicationException e)
			 * { e.printStackTrace(); }
			 */

			// ***get company
			/*
			 * CompanyLogic companyLogic = new CompanyLogic(); try { Company
			 * company_99 = new Company(); company_99 = companyLogic.getCompany(9);
			 * System.out.println(company_99);
			 * 
			 * } catch (ApplicationException e) { e.printStackTrace(); }
			 */

			// ***get all company
			/*
			 * CompanyLogic companyLogic = new CompanyLogic(); List<Company>
			 * allComanies = new ArrayList<>(); try { allComanies =
			 * companyLogic.getAllCompany(); } catch (ApplicationException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); }
			 * System.out.println(allComanies);
			 */

			// ***login

			/*CompanyLogic logic = new CompanyLogic();
			try {
				String comp_name = null;
				String password = null;
				logic.login(comp_name, password);
				System.out.println("login succeeded");
			} catch (ApplicationException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			// ***create company
					
			//		  CompanyLogic logic = new CompanyLogic();
			//		  try {
			//		  logic.createCompany(company_13);

			//		  } catch (ApplicationException e) { 
			//		  // TODO Auto-generated catch block
			//		   e.printStackTrace();
			//		  }
					 	

			/////////////////////////////////////////////
		}

	}


