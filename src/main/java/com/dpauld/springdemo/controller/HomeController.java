package com.dpauld.springdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String showPage() { // this method is only returning the view page name as a string. Internally Spring will add suffix and prefixes using this name and then show the page to the user.
		return "main-menu";
	}
}

