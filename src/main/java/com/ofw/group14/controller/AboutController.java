package com.ofw.group14.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ofw.group14.entity.Categories;
import com.ofw.group14.entity.ShoppingCart;
import com.ofw.group14.service.CategoriesService;
import com.ofw.group14.service.ProductsService;

@Controller
@SessionAttributes({"username","cart","user"})
public class AboutController {

	@Autowired
	CategoriesService catgoriesService;
	@Autowired
	ProductsService productsService;
	 
	
	@RequestMapping("/about-us")
	public String about(ModelMap modelMap, HttpSession httpSession){  
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		  
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
		} 
		
		return "/frontend/about";
	}
	
	@RequestMapping("/delivery")
	public String delivery(ModelMap modelMap, HttpSession httpSession){  
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		  
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
		} 
		
		return "/frontend/delivery";
	}
	
	@RequestMapping("/news")
	public String news(ModelMap modelMap, HttpSession httpSession){  
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		  
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
		} 
		
		return "/frontend/news";
	}
	 
	@RequestMapping("/contact")
	public String contact(ModelMap modelMap, HttpSession httpSession){  
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		  
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
		} 
		
		return "/frontend/contact";
	}
	 
	
	 
}
