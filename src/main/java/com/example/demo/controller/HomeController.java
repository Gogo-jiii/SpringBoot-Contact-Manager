package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.dao.UserRepo;
import com.example.demo.models.User;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String test(Model model) {
		model.addAttribute("title", "Home page");
		return "home.html";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About page");
		return "about.html";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Registration page");
		return "signup.html";
	}
}
