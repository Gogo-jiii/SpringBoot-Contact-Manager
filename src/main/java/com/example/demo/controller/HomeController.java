package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.dao.UserRepo;
import com.example.demo.models.Message;
import com.example.demo.models.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserRepo repo;
	
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
		model.addAttribute("user", new User());
		return "signup.html";
	}
	
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user, @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model, HttpSession session) {
		try {
			if(!agreement) {
				System.out.println("Please agree the Term and conditions!");
				throw new Exception(" Please agree the Term and conditions!");
			}
			System.out.println("Agreement: " + agreement);
			System.out.println("User: " + user);
			
			user.setEnabled(true);
			user.setImageUrl("default");
			user.setRole("user");
			
			repo.save(user);
			
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Successfully registered!", "alert-success"));
			
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(), "alert-warning"));
		}
		
		return "signup.html";
	}
}
