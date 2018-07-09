package com.ofw.group14.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ofw.group14.entity.Categories;
import com.ofw.group14.entity.Products;
import com.ofw.group14.entity.ShoppingCart;
import com.ofw.group14.service.CategoriesService;
import com.ofw.group14.service.ProductsService;

/**
 * @author VS9X64bit
 * Page shows detail a chosen item
 * Mapping url with view 
 */
@Controller
@SessionAttributes({"username","cart"})
public class PreviewController {
	@Autowired
	CategoriesService catgoriesService;
	@Autowired
	ProductsService  productService;
	
	@RequestMapping("/preview-{idproduct}")
	public String home(@PathVariable int idproduct , ModelMap modelMap, HttpSession httpSession){
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		
		Products products = productService.getProductDetailbyId(idproduct);
		modelMap.addAttribute("preview", products);
		
		List<Products> listProducts = productService.getRelatedProduct(idproduct, 4);
		modelMap.addAttribute("relatedProduct", listProducts);
		
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
		}
		
		return "/frontend/preview";
	}
}
