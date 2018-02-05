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

import com.rpcherrera.blogs.entity.Blog;
import com.rpcherrera.blogs.entity.User;
import com.rpcherrera.blogs.service.BlogService;
import com.rpcherrera.blogs.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;

	@ModelAttribute("user")
	private User constructUser() {
		return new User();
	}
	
	@ModelAttribute("blog")
	private Blog constructBlog() {
		return new Blog();
	}

	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@RequestMapping("/users/{id}")
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
	
	@RequestMapping("/mypage")
	public String userPage(Model model, Principal principal) {
		String userEmail = principal.getName();
		model.addAttribute("user", userService.fineOneWithBlogs(userEmail));
		return "user-detail";
	}
	
	@RequestMapping(value="/mypage", method = RequestMethod.POST)
	public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal, Model model) {
		String userEmail = principal.getName();
		blogService.saveBlog(blog, userEmail);
		model.addAttribute("user", userService.fineOneWithBlogs(userEmail));
		return "user-detail";
	}
}