package com.bookauthor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookauthor.entity.UserInfo;
import com.bookauthor.service.SecurityInterface;

@Controller
public class SecurityController {
	@Autowired
	private SecurityInterface Service;

	// add the user detailes
//	@PostMapping("/adduser")
//	@ResponseBody
//	public String adduser(@RequestBody UserInfo userInfo) {
//		return Service.adduser(userInfo);
//	}
//	@GetMapping("/logins")
//	public String loginpage() {
//		System.out.println("called");
//		return "login";
//	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		// You don't need to implement the login logic here, Spring Security will handle
		// it for you
		return "redirect:/allauthors";
	}

//	@GetMapping("/register")
//	public String Registration() {
//		return "registration";
//	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("userInfo", new UserInfo());
		return "registration";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("userInfo") UserInfo userInfo, Model model) {
		if (Service.userExists(userInfo.getUserName())) {
			model.addAttribute("usernameError", "Username already exists!");
			return "registration";
		}

		Service.saveuser(userInfo);

		return "redirect:/login";
	}

}
