package com.rpcherrera.blogs.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpcherrera.blogs.entity.Blog;
import com.rpcherrera.blogs.service.BlogService;
import com.rpcherrera.blogs.service.UserService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("blog")
	private Blog constructBlog() {
		return new Blog();
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
	
	@RequestMapping("/blog/remove/{id}")
	public String doRemoveBlog(@PathVariable int id) {
		Blog blog = blogService.findOne(id);
		blogService.deleteBlog(blog);
		return "redirect:/mypage.html";
	}
}
