package com.ofw.group14.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.w3c.dom.stylesheets.LinkStyle;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ofw.group14.entity.Brands;
import com.ofw.group14.entity.Categories;
import com.ofw.group14.entity.JsonProducts;
import com.ofw.group14.entity.Products;
import com.ofw.group14.entity.ShoppingCart;
import com.ofw.group14.service.ProductsService;
import com.ofw.group14.service.UserService;

/**
 * @author VS9X64bit
 * Mapping ajax requests - views
 */
 
@Controller
@RequestMapping("api/")
@SessionAttributes("cart")
public class AjaxApiController {

	@Autowired
	UserService userService;  
	@Autowired
	ProductsService productService;
	@Autowired
	ServletContext context;
	
	@GetMapping("checkusername")
	@ResponseBody
	public String checkUserNameExists(@RequestParam String username){
		
		boolean check = userService.checkUserExists(username); 
		return ""+check;
	}
	
	
	@GetMapping("checkemail")
	@ResponseBody
	public String checkEmailExists(@RequestParam String email){
		boolean check = userService.checkEmailExists(email);
		return ""+check;
	}
	
	@GetMapping("addtocart")
	@ResponseBody
	public void addCart(@RequestParam int prodid,@RequestParam String prodimage,@RequestParam String prodname,@RequestParam int prodprice,@RequestParam String prodmodel,
			@RequestParam int prodquantity,@RequestParam int prodnumber,HttpServletRequest request, HttpSession httpSession){
		//
		if(null == httpSession.getAttribute("cart")){
			List<ShoppingCart> listCarts = new ArrayList<ShoppingCart>();
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setProduct_id(prodid);
			shoppingCart.setImage(prodimage);
			shoppingCart.setProductname(prodname);
			shoppingCart.setPrice(prodprice);
			shoppingCart.setModel(prodmodel);
			shoppingCart.setAvailable(prodquantity);
			shoppingCart.setQuanlity(1);
			
			listCarts.add(shoppingCart);
			httpSession.setAttribute("cart", listCarts);  
			 
		}else{
			List<ShoppingCart> listCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			int position = checkExistOnCart(listCarts, httpSession, prodid, prodmodel);
			if(position == -1){
				
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setProduct_id(prodid);
				shoppingCart.setImage(prodimage);
				shoppingCart.setProductname(prodname);
				shoppingCart.setPrice(prodprice);
				shoppingCart.setModel(prodmodel);
				shoppingCart.setAvailable(prodquantity);
				shoppingCart.setQuanlity(1);
				listCarts.add(shoppingCart); 
			}else{ 
				int newnumber = listCarts.get(position).getQuanlity() + 1; 
				listCarts.get(position).setQuanlity(newnumber);
			}
		}
		/*List<ShoppingCart> listCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
		for (ShoppingCart item : listCarts) {
			System.out.println(item.getProductid()+" "+item.getProductname()+" "+item.getModel()
					+" "+item.getAvailable());
		}
		System.out.println(listCarts.size());*/
	}
	
	private int checkExistOnCart(List<ShoppingCart> listCarts, HttpSession httpSession, int id, String model){ 
		for(int i=0; i<listCarts.size();i++){
			if(listCarts.get(i).getProduct_id() ==id && listCarts.get(i).getModel().equals(model) ==true){
				return i;
			}
		}
		
		return -1;
	}
	
	@GetMapping("number-items-cart")
	@ResponseBody
	public String getNumberItemsCart(HttpSession httpSession, ModelMap modelMap){
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			return shoppingCarts.size()+"";
		}
		
		return "";
	}
	
	@GetMapping("update-shopping-cart")
	@ResponseBody
	public void updateCart(@RequestParam int prodid, @RequestParam String prodmodel,@RequestParam int prodnumber, HttpSession httpSession, ModelMap modelMap){
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart> listCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			int position = checkExistOnCart(listCarts, httpSession, prodid, prodmodel);
			 
			listCarts.get(position).setQuanlity(prodnumber);

		} 
	}
	
	@GetMapping("remove-shopping-cart")
	@ResponseBody
	public void removeCart(@RequestParam int prodid, @RequestParam String prodmodel, HttpSession httpSession, ModelMap modelMap){
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart> listCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			int position = checkExistOnCart(listCarts, httpSession, prodid, prodmodel);
			listCarts.remove(position);

		} 
	}
	
	@PostMapping(path="load-more-json", produces="application/json; charset=utf-8")
	@ResponseBody
	public List<JsonProducts> loadMoreJson(@RequestParam int cateid, @RequestParam int at, @RequestParam int total){
		List<JsonProducts> jsonProducts = new  ArrayList<JsonProducts>();
		Categories categories = new Categories();
		Brands brands = new Brands();
		
		List<Products> products = productService.getProductsbyCategory(cateid, at, total+1); 
		for (Products item : products) {  
				JsonProducts item2 = new JsonProducts();
				categories.setCategory_id(item.getCategories().getCategory_id());
				categories.setName(item.getCategories().getName());
				brands.setBrand_id(item.getBrands().getBrand_id());
				brands.setName(item.getBrands().getName());
				
				item2.setProduct_id(item.getProduct_id());
				item2.setName(item.getName());
				item2.setCategories(categories);
				item2.setBrands(brands);
				item2.setModel(item.getModel());
				item2.setConfiguration(item.getConfiguration());
				item2.setFeatured(item.getFeatured());
				item2.setImage(item.getImage());
				item2.setQuantity(item.getQuantity());
				item2.setPrice(item.getPrice());
				item2.setCreated_at(item.getCreated_at());
				item2.setDesciption_detail(item.getDesciption_detail());
				item2.setDescription(item.getDescription());
				item2.setProducts_sold(item.getProducts_sold());
				
				jsonProducts.add(item2);   
		} 
		System.out.println(jsonProducts);
		
		
		return jsonProducts;
		
	}
	
	@GetMapping(path="loadmore", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String loadMore(@RequestParam int cateid, @RequestParam int at, @RequestParam int total){ 
		String html ="";
		List<Products> products = productService.getProductsbyCategory(cateid, at, total);
		for(Products item: products){
			
			html += "<div class='grid_1_of_4 images_1_of_4'>";
			
			html += "<a href=\"/FrameWorkOriented/preview-"+item.getProduct_id()+"\"> ";
			html += "<img class='prod-img' data-img='/resources/image/uploads/"+item.getImage()+"' src=\"/FrameWorkOriented/resources/image/uploads/"+item.getImage()+"\" alt=\"\" /></a>";
			html += "<h2 class='prod-name' data-id='"+item.getProduct_id()+"'>"+item.getName()+"</h2>";
			html += "<a class='prod-cate' data-cate='"+item.getCategories().getCategory_id()+"'></a>";
			html += "<div class='price-details' data-model='"+item.getModel()+"'>";
			html += " <div class='price-number' data-availble='"+item.getQuantity()+"'>";
			html += "<p><span class='rupees prod-price' data-price='"+item.getPrice()+"'>"+item.getPrice()+"</span>đ</p>";
			html += " </div>";
			html += "<div class='add-cart'>	";
			html += "<h4><a class='btn_Add_Cart_Custom'>Add to Cart</a></h4>";
			html += "</div>";
			html += "<div class='clear'></div>";
			html += "</div>";
			html += "</div>";
			 
		}
		
		return html;
	}
	
	@GetMapping(path="manage-pagination", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getPaging(@RequestParam int at, @RequestParam int total ){
		
		String html = "";
		List<Products> list = productService.getProductsLimit(at, total);
		for (Products item : list) {
			html += "<tr>";
			html += "<td><input class=\"select_item\" type=\"checkbox\" value='"+item.getProduct_id()+"'/></td>";
			html += "<td class=\"\" data-id='"+item.getProduct_id()+"'>"+item.getName()+"</td>";
			html += "<td class=\"\">"+item.getQuantity() +"</td>";
			html += "<td class=\"\">"+item.getPrice() +"</td>";
			html += "<td class=''><button class='btn_loadFormUpdate' data-id='"+item.getProduct_id()+"'>Update</button></td>";
			
			html += "</tr>";
		} 
		
		return html;
	}
	
	@GetMapping("manage-product-delete")
	@ResponseBody
	public String deleteProductSelected(@RequestParam int productid){
		productService.deleteProductSelected(productid);
		return "";
	}
	
	@PostMapping("upload-file")
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest request){
		
		String pathFile = context.getRealPath("/resources/image/uploads/");
		
		Iterator<String > listNames = request.getFileNames();
		MultipartFile multipartFile = request.getFile(listNames.next());
		
		File fileSave = new File(pathFile + multipartFile.getOriginalFilename());
		try {
			multipartFile.transferTo(fileSave);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pathFile);
		return "";
	}
	
	@PostMapping("add-new-product")
	@ResponseBody
	public void addProduct(@RequestParam String dataJson, HttpSession httpSession, ModelMap modelMap){
		 System.out.println(dataJson);
		 ObjectMapper objectMapper = new ObjectMapper();
		 
		/* try {
			Products products = objectMapper.readValue(dataJson, Products.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 
		 try {
			Products product = new  Products();
			Categories categories = new Categories();
			Brands brands = new Brands();
			
			JsonNode jsonObject = objectMapper.readTree(dataJson);
			categories.setCategory_id(jsonObject.get("categories").asInt());
			brands.setBrand_id(jsonObject.get("brands").asInt());
			
			product.setName(jsonObject.get("name").asText());
			product.setDescription(jsonObject.get("description").asText());
			product.setDesciption_detail(jsonObject.get("desciption_detail").asText());
			product.setImage(jsonObject.get("image").asText()); 
			product.setCategories(categories);
			product.setQuantity(jsonObject.get("quantity").asInt());
			product.setBrands(brands);
			product.setModel(jsonObject.get("model").asText());
			product.setConfiguration(jsonObject.get("configuration").asText());
			product.setPrice(jsonObject.get("price").asInt());
			product.setFeatured(jsonObject.get("featured").asInt());
			product.setCreated_at(jsonObject.get("created_at").asInt());
			
			productService.addProduct(product);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@PostMapping(path="select-product-by-identity", produces="application/json; charset=utf-8")
	@ResponseBody
	public JsonProducts selectProduct(@RequestParam int idproduct){
		JsonProducts jsonProducts = new JsonProducts();
		
		Products product = productService.getProductDetailbyId(idproduct);
		Categories categories = new Categories();
		Brands brands = new Brands();
		categories.setCategory_id(product.getCategories().getCategory_id());
		categories.setName(product.getCategories().getName());
		brands.setBrand_id(product.getBrands().getBrand_id());
		brands.setName(product.getBrands().getName());
		
		jsonProducts.setProduct_id(product.getProduct_id());
		jsonProducts.setName(product.getName());
		jsonProducts.setCategories(categories);
		jsonProducts.setBrands(brands);
		jsonProducts.setModel(product.getModel());
		jsonProducts.setConfiguration(product.getConfiguration());
		jsonProducts.setFeatured(product.getFeatured());
		jsonProducts.setImage(product.getImage());
		jsonProducts.setQuantity(product.getQuantity());
		jsonProducts.setPrice(product.getPrice());
		jsonProducts.setCreated_at(product.getCreated_at());
		jsonProducts.setDesciption_detail(product.getDesciption_detail());
		jsonProducts.setDescription(product.getDescription());
		jsonProducts.setProducts_sold(product.getProducts_sold());
		
		//System.out.println(jsonProducts);
		return jsonProducts;
	}
	
	@PostMapping("update-selected-product-by-identity")
	@ResponseBody
	public void updateProduct(@RequestParam String dataJson, HttpSession httpSession, ModelMap modelMap){
		 System.out.println(dataJson);
		 ObjectMapper objectMapper = new ObjectMapper();
		  
		 
		 try {
			Products product = new  Products();
			Categories categories = new Categories();
			Brands brands = new Brands();
			
			JsonNode jsonObject = objectMapper.readTree(dataJson);
			categories.setCategory_id(jsonObject.get("categories").asInt());
			brands.setBrand_id(jsonObject.get("brands").asInt());
			
			product.setName(jsonObject.get("name").asText());
			product.setDescription(jsonObject.get("description").asText());
			product.setDesciption_detail(jsonObject.get("desciption_detail").asText());
			product.setImage(jsonObject.get("image").asText()); 
			product.setCategories(categories);
			product.setQuantity(jsonObject.get("quantity").asInt());
			product.setBrands(brands);
			product.setModel(jsonObject.get("model").asText());
			product.setConfiguration(jsonObject.get("configuration").asText());
			product.setPrice(jsonObject.get("price").asInt());
			product.setFeatured(jsonObject.get("featured").asInt());
			product.setCreated_at(jsonObject.get("created_at").asInt());
			
			product.setProduct_id(jsonObject.get("product_id").asInt());
			productService.updateProduct(product);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	/** Signup using ajax
	 * 
	 * @GetMapping("signup")
	@ResponseBody
	public String execSignup(HttpServletRequest request,ModelMap map	){
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String passWord = request.getParameter("password");
		String repassWord = request.getParameter("repassword");
		
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassWord(passWord);
		
		boolean addUser = userServiceImpl.addUser(user); 
		
		return ""+addUser;
	}*/
}
