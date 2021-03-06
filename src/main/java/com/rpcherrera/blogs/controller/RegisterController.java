package com.rpcherrera.blogs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rpcherrera.blogs.entity.User;
import com.rpcherrera.blogs.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	private User constructUser() {
		return new User();
	}
	
	@RequestMapping()
	public String displayRegisterPage() {
		return "user-register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doRegister(Model model, @Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "user-register";
		}
		userService.saveUser(user);
		redirectAttributes.addFlashAttribute("success", true);
		return "redirect:/register.html";
	}
	
	@RequestMapping("/available")
	@ResponseBody
	public String checkAvailableEmail(@RequestParam String email) {
		Boolean isEmailAvailable = userService.findOneWithBlogsByEmail(email) == null;
		return isEmailAvailable.toString();
	}
}
