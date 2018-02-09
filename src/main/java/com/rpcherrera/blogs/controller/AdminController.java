package com.rpcherrera.blogs.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rpcherrera.blogs.entity.Blog;
import com.rpcherrera.blogs.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("blog")
	private Blog constructBlog() {
		return new Blog();
	}
	
	@RequestMapping()
	public String users(Model model, Principal principal) {
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("loggedInUser", principal.getName());
		return "users";
	}
	
	@RequestMapping("/remove/{id}")
	public String doRemoveUser(@PathVariable int id, Model model) {
		userService.deleteUser(id);
		model.addAttribute("deletedUser", userService.findOne(id));
		return "redirect:/users.html?success=true";
	}
}
