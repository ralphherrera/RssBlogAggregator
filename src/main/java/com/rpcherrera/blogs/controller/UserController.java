package com.rpcherrera.blogs.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpcherrera.blogs.entity.User;
import com.rpcherrera.blogs.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	private User constructUser() {
		return new User();
	}
	
	@RequestMapping("/users")
	public String users(Model model, Principal principal) {
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("loggedInUser", principal.getName());
		return "users";
	}

	@RequestMapping("/user/{id}")
	public String userDetails(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}

	@RequestMapping("/register")
	public String displayRegisterPage() {
		return "user-register";
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user, BindingResult result ) {
		if (result.hasErrors()) {
			return "user-register";
		}
		userService.saveUser(user);
		return "redirect:/register.html?success=true";
	}
	
	@RequestMapping("/user/remove/{id}")
	public String doRemoveUser(@PathVariable int id, Model model) {
		userService.deleteUser(id);
		model.addAttribute("deletedUser", userService.findOne(id));
		return "redirect:/users.html?success=true";
	}
}