package com.rpcherrera.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rpcherrera.blogs.service.ItemService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping()
	public String index(Model model) {
		model.addAttribute("items", itemService.getItems());
		return "index";
	}
}
