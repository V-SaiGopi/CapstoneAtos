package com.watch.rolex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.watch.rolex.model.Adminregister;
import com.watch.rolex.model.Userregister;
import com.watch.rolex.service.AdminregisterService;
import com.watch.rolex.service.UserregisterService;

@Controller
public class HomeController {

	@Autowired
	UserregisterService userregisterService;
	
	@Autowired
	AdminregisterService adminregisterService;

	@GetMapping("/")
	public String showHome() {
		System.out.println("in home");
		return "home.html";
	}
	
	@GetMapping("/index")
	public String showHome1() {
		System.out.println("in home");
		return "index.html";
	}
	
	@GetMapping("/home")
	public String homepage() {
		System.out.println("home");
		return "home.html";
	}

	@GetMapping("/UserLogin")
	public String loginPage() {
		System.out.println("login");
		return "UserLogin.html";
	}

	@GetMapping("/AdminRegister")
	public String AdminPage() {
		System.out.println("Adminregister");
		return "AdminRegister.html";
	}
	
	@PostMapping("/UserLogin")
	public String validateLoginPage(@ModelAttribute Userregister userregister) {
		List<Userregister> userList = userregisterService.findByName(userregister.getUname(), userregister.getPword());
		if (userList.isEmpty()) {
			return "UserLogin.html";
		} else {
			return "index.html";
		}
	}
	
	@PostMapping("/AdminLogin")
	public String validateadminPage(@ModelAttribute Adminregister adminregister) {
		List<Adminregister> userList = adminregisterService.findByName(adminregister.getUname(), adminregister.getPword());
		if (userList.isEmpty()) {
			return "AdminLogin.html";
		} else {
			return "adminDashboard.html";
		}
	}

	@GetMapping("/UserRegister")
	public String showSignUpPage() {
		return "UserRegister.html";
	}

	@PostMapping("/UserRegister")
	public String registeringUser(@ModelAttribute Userregister userregister) {
		userregisterService.insertData(userregister);
		return "UserLogin.html";
	}
	
	@PostMapping("/AdminRegister")
	public String adminregisteringUser(@ModelAttribute Adminregister adminregister) {
		adminregisterService.insertData(adminregister);
		return "AdminLogin.html";
	}

	@RequestMapping("/userreg")
	public String userRegisteredRedirect() {
		return "index.html";
	}
	
	@RequestMapping("/adminreg")
	public String adminRegisteredRedirect() {
		return "adminDashboard.html";
	}
	
	@GetMapping("/Coupons")
	public String CouponPage() {
		System.out.println("Coupons");
		return "Coupons.html";
	}
	
	@GetMapping("/paymentpage")
	public String paymentPage() {
		System.out.println("paymentpage");
		return "paymentpage.html";
	}
	
	@GetMapping("/AdminLogin")
	public String AdminLogin() {
		System.out.println("AdminLogin");
		return "AdminLogin.html";
	}
	
	@GetMapping("/Success")
	public String Success() {
		System.out.println("Success");
		return "Success.html";
	}
	
	@GetMapping("/adminDashboard")
	public String adminDashboard() {
		System.out.println("adminDashboard");
		return "adminDashboard.html";
	}
	
	@RequestMapping("/adminDashboard")
	public String adminDashboardRedirect() {
		return "adminDashboard.html";
	}
	
	@GetMapping("/listProduct")
	public String listProduct() {
		System.out.println("listProduct");
		return "listProduct.html";
	}
	
	@GetMapping("/couponcode")
	public String couponcode() {
		System.out.println("couponcode");
		return "couponcode.html";
	}
	
	@GetMapping("/couponList")
	public String couponList() {
		System.out.println("couponList");
		return "couponList.html";
	}
	
	@GetMapping("/admin")
	public String admin() {
		System.out.println("admin");
		return "admin.html";
	}
}
