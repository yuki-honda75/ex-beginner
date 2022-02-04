package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author hondayuki
 *
 */
@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/post")
	public String post(Integer price1, Integer price2, Integer price3) {
		int totalPrice = price1 + price2 + price3;
		int totalPriceTax = (int)(totalPrice * 1.1);
		
		application.setAttribute("totalPrice", totalPrice);
		application.setAttribute("totalPriceTax", totalPriceTax);
		
		return "exam03-result";
	}
}
