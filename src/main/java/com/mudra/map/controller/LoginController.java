package com.mudra.map.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mudra.map.entity.UserInfo;
import com.mudra.map.service.UserInfoService;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserInfoService userInfoService;

	@GetMapping("/signin")
	public String signInHandler(Model model) {
		LOGGER.info("LoginController.class	->	signInHandler()	->	start");
		return "signin";
	}
	
	@PostMapping("/verify-user-credential")
	public String verifyUser(@ModelAttribute("userInfo") UserInfo userInfo, Model model) {
		
		LOGGER.info("LoginController.class	->	verifyUser()	->	start");

		UserInfo verifyUser = userInfoService.verifyUser(userInfo);
		
		if(verifyUser.getMobile_no() == null) {
			model.addAttribute("message", "Invalid Credential");
			return "redirect:/signin";
		}else {
			model.addAttribute("user_info", verifyUser);
			return "home";
		}	
	}
	
	@PostMapping("/add-new-user")
	public String addNewUser(@ModelAttribute("userInfo") UserInfo userInfo){
		
		LOGGER.info("LoginController.class	->	addNewUser()	->	start");
		userInfoService.addNewUser(userInfo);
		return "redirect:/signin";
	}
}
