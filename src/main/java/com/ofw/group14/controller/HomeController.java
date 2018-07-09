package com.ofw.group14.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ofw.group14.dao.SearchDao;
import com.ofw.group14.daoimpl.SearchDaoImpl;
import com.ofw.group14.entity.Brands;
import com.ofw.group14.entity.Categories;
import com.ofw.group14.entity.JsonProducts;
import com.ofw.group14.entity.Products;
import com.ofw.group14.entity.ShoppingCart;
import com.ofw.group14.service.CategoriesService;
import com.ofw.group14.service.ProductsService;

/**
 * @author VS9X64bit
 * shows home page and search page
 */
@Controller
@SessionAttributes({"username","cart"})
public class HomeController {

	@Autowired
	CategoriesService catgoriesService;
	@Autowired
	ProductsService productsService;
	 
	
	@RequestMapping("/")
	public String home(ModelMap modelMap, HttpSession httpSession){  
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		
		List<Products> listNewProducts = productsService.getNewProducts(4);
		List<Products> listCommonProducts = productsService.getCommonProducts(8);
		modelMap.addAttribute("newProducts", listNewProducts);
		modelMap.addAttribute("commonProducts", listCommonProducts);
		
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
		} 
		
		System.out.println("access "+ httpSession.getAttribute("role"));
		return "/frontend/index";
	}
	
	 
	
	/*@GetMapping("/home")
	public String getHome(ModelMap modelMap){ 
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		return "index";
	}*/
	
	@Autowired
	SearchDao searchDao;
	
	@ResponseBody
	@RequestMapping(value = "/indexData", method = RequestMethod.GET)
	public String indexData() {
		try {
			searchDao.indexProducts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Indexed at " + new Date().toGMTString();
	}

 
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(value = "keyword") String keyword,ModelMap modelMap, HttpSession httpSession) {
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
		}  
		
		try {
			searchDao.indexProducts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		List<Products> products =  searchDao.search(keyword);
		modelMap.addAttribute("listsearch",products);
	 
		return "/frontend/search"; 
	}
}
