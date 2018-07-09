package com.ofw.group14.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ofw.group14.entity.Categories;
import com.ofw.group14.entity.Products;
import com.ofw.group14.entity.ShoppingCart;
import com.ofw.group14.service.CategoriesService;
import com.ofw.group14.service.ProductsService;

/**
 * @author VS9X64bit
 * Mapping all-products link to view show all products existing system on webpage
 */
@Controller
@SessionAttributes({"username","cart"})
public class AllProductsController {

	@Autowired
	CategoriesService catgoriesService;
	@Autowired
	ProductsService productsService;
	
	@RequestMapping("/all-products")
	public String productsAll(HttpServletRequest request,HttpSession session, ModelMap modelMap){
		
		List<Categories> listCategories = catgoriesService.getCategories(); 
		modelMap.addAttribute("categories", listCategories);
		
		if(null !=  session.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) session.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
		}
		
		
		//offset is page number 
		String offset = (String)request.getParameter("offset"); 
		
		// result is number of record displayed on each page
		int result = 8;
		// size is the total number of record present in DB
		int size = productsService.getSize();
		int page = (int) Math.ceil((double)size/result);
		List<Integer> pageList = new ArrayList<Integer>();
		List<Products> products ;
		/*in the beginning we set page number zero */
		if(offset!=null){  
				int offsetreal = Integer.parseInt(offset) - 1;
				offsetreal = offsetreal*result;
				products = productsService.getProductPaging(result, offsetreal);
			   
		}else{
			products = productsService.getProductPaging(result,0);
		   
		}  
		
		if(offset!=null){
			int listsize = page;
			if(Integer.parseInt(offset) <6){
				if(listsize>=10){
					for(int i= 1; i<=10;i++){
						pageList.add(i);
					}
				}else{
					for(int i= 1; i<=listsize;i++){
						pageList.add(i);
					}
				} 
			}else{
				if(listsize >= 10 && Integer.parseInt(offset)-5 >0){
					List<Integer> temp = new ArrayList<Integer>(); 
					for(int i=Integer.parseInt(offset);i>Integer.parseInt(offset)-6;i--){
						temp.add(i);
					}
					for(int i=temp.size()-1;i>=0;i--){
						pageList.add(temp.get(i));
					}
				}if(listsize >= 10 && Integer.parseInt(offset)+5<listsize){
					for(int i=Integer.parseInt(offset)+1;i<Integer.parseInt(offset)+5;i++){
						pageList.add(i);
					}
				}else if(listsize >= 10){ 
					for(int i=Integer.parseInt(offset)+1;i<=listsize;i++){
						pageList.add(i);
					}
				}
				
			}
		}else{
			int listsize = page;
			if(listsize>=10){
				for(int i= 1; i<=10;i++){
					pageList.add(i);
				}
			}else{
				for(int i= 1; i<=listsize;i++){
					pageList.add(i);
				}
			}
		}
		
		modelMap.addAttribute("totalPage", page);
		modelMap.addAttribute("pageList", pageList);
		modelMap.addAttribute("productList", products);
		
		return "/frontend/allproduct";
	}
}
