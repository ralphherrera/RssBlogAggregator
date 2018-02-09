package com.rpcherrera.blogs.controller;

import java.security.Principal;

import javax.validation.Valid;

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
	
	@RequestMapping("/user/{id}")
	public String userDetails(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-details";
	}
	
	@RequestMapping("/mypage")
	public String userPage(Model model, Principal principal) {
		String userEmail = principal.getName();
		model.addAttribute("user", userService.fineOneWithBlogs(userEmail));
		return "account-details";
	}
	
	@RequestMapping(value="/mypage", method = RequestMethod.POST)
	public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, BindingResult result, Principal principal) {
		if (result.hasErrors()) { 
			return userPage(model, principal);
		}
		String userEmail = principal.getName();
		blogService.saveBlog(blog, userEmail);
		model.addAttribute("user", userService.fineOneWithBlogs(userEmail));
		return "account-details";
	}
	
	@RequestMapping("/blog/remove/{id}")
	public String doRemoveBlog(@PathVariable int id) {
		Blog blog = blogService.findOne(id);
		blogService.deleteBlog(blog);
		return "redirect:/mypage.html";
	}

}