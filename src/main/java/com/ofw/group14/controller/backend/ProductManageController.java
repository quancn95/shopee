package com.ofw.group14.controller.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ofw.group14.entity.Brands;
import com.ofw.group14.entity.Categories;
import com.ofw.group14.entity.Products;
import com.ofw.group14.service.BrandsService;
import com.ofw.group14.service.CategoriesService;
import com.ofw.group14.service.ProductsService;

@Controller
@RequestMapping("/product-management")
public class ProductManageController {
	
	@Autowired
	ProductsService productService;
	@Autowired
	CategoriesService catgoriesService;
	@Autowired
	BrandsService brandsService;
	
	@GetMapping
	public String getProdMmt(ModelMap modelMap){
		
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		List<Brands> listBrands = brandsService.getBrands();
		modelMap.addAttribute("brands", listBrands);
		
		int total = 5;
		List<Products> listProd = productService.getProductsLimit(0,total);
		List<Products> allProd = productService.getAllProduct();
		int page = (int) Math.ceil(allProd.size()/(double)total);
		
		
		
		modelMap.addAttribute("listproductmnt",listProd);
		modelMap.addAttribute("allproductmnt",allProd);
		modelMap.addAttribute("allpagemnt",page);
		return "/backend/productmanage";
	}
}
