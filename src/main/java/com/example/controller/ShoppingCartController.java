package com.example.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/exam06")
public class ShoppingCartController {
	@Autowired
	private ServletContext application;
	
	@Autowired
	private HttpSession session;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("")
	public String index(Model model) {
		List<Item> itemList = (List<Item>)application.getAttribute("itemList");
		if (itemList == null) {
			itemList = new ArrayList<Item>();
			Item item1 = new Item("手帳ノート", 1000);
			Item item2 = new Item("文房具セット", 1500);
			Item item3 = new Item("ファイル", 2000);
			itemList.add(item1);
			itemList.add(item2);
			itemList.add(item3);
		}
		application.setAttribute("itemList", itemList);
		
		List<Item> cartList = (List<Item>)session.getAttribute("cartList");
		int totalPrice = 0;
		if (cartList == null) {
			cartList = new LinkedList<>();
		}
		
		for (Item item : cartList) {
			totalPrice += item.getPrice();
		}
		session.setAttribute("cartList", cartList);
		
		model.addAttribute("totalPrice", totalPrice);
		return "item-and-cart";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/incart/{index}")
	public String inCart(@PathVariable("index") Integer index, Model model) {
		List<Item> itemList = (List<Item>)application.getAttribute("itemList");
		Item item = itemList.get(index);
		
		LinkedList<Item> cartList = (LinkedList<Item>)session.getAttribute("cartList");
		if (cartList == null) {
			cartList = new LinkedList<>();
		}
		cartList.add(item);
		session.setAttribute("cartList", cartList);
		
		return "redirect:/exam06";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete/{index}")
	public String delete(@PathVariable("index") Integer index, Model model) {
		List<Item> cartList = (List<Item>)session.getAttribute("cartList");
		cartList.remove((int)index);
		
		session.setAttribute("cartList", cartList);
		
		return "redirect:/exam06";
	}
}
