package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 
 * @author hondayuki
 *
 */
@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	@RequestMapping("")
	public String index() {
		return "exam04";
	}
	
	@RequestMapping("post")
	public String post(/*@Validated userForm, 
			BindingResult result,*/
			RedirectAttributes redirectAttributes,
			Model model) {
		
		return "redirect:/exam04/show";
	}
	
	@RequestMapping("/show")
	public String showResult() {
		return "exam04-result";
	}
}
