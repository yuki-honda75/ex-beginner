package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 
 * @author hondayuki
 *
 */
@Controller
@RequestMapping("/exam01")
public class Exam01Controller {
	@RequestMapping("")
	public String index() {
		return "exam01";
	}
	
	@RequestMapping("/post")
	public String post(String name, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("name", name);
		
		return "redirect:/exam01/result";
	}
	
	@RequestMapping("/result")
	public String showResult() {
		return "exam01-result";
	}
}
