package com.ofw.group14.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ofw.group14.entity.Categories;
import com.ofw.group14.entity.Products;
import com.ofw.group14.entity.ShoppingCart;
import com.ofw.group14.service.CategoriesService;
import com.ofw.group14.service.ProductsService;

@Controller
@SessionAttributes({"username","cart"})
public class ProductController {
	@Autowired
	ProductsService productsService;
	@Autowired
	CategoriesService catgoriesService;
	
	/*@RequestMapping("/all-product")
	public String allProduct(ModelMap modelMap,HttpSession httpSession){  
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		 
		List<Products> listAllProducts = productsService.getAllProduct();
		modelMap.addAttribute("allProducts", listAllProducts);
		
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
		}
		
		return "/frontend/allproduct";
	}*/
	
	
	/**
	 * Show all item by a chosen category
	 * @param idcategory
	 * @param modelMap
	 * @param httpSession
	 * @return view shows items of a category
	 */
	@RequestMapping("/cate-{idcategory}")
	public String productByCate(@PathVariable int idcategory, ModelMap modelMap, HttpSession httpSession){  
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		
		List<Products> listProductByCate = productsService.getProductsbyCategory(idcategory,0,16);
		modelMap.addAttribute("cateProducts", listProductByCate);
		
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
		}
		
		return "/frontend/prodbycategory";
	}
}
