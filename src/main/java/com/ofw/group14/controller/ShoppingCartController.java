package com.ofw.group14.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ofw.group14.entity.OrderDetails;
import com.ofw.group14.entity.OrderDetailsID;
import com.ofw.group14.entity.Orders;
import com.ofw.group14.entity.ShoppingCart;
import com.ofw.group14.entity.User;
import com.ofw.group14.service.CategoriesService;
import com.ofw.group14.service.OrderDetailsService;
import com.ofw.group14.service.OrdersService;
import com.ofw.group14.service.ProductsService;

/**
 * @author VS9X64bit
 * Mapping url with view shows page shopping-cart 
 */
@Controller
@SessionAttributes({"username","cart"})
public class ShoppingCartController {
	@Autowired
	CategoriesService catgoriesService;
	@Autowired
	ProductsService  productService;
	@Autowired
	OrdersService ordersService;
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@RequestMapping("/shopping-cart/")
	public String getShoppingCart(ModelMap modelMap, HttpSession httpSession){
		if(null !=  httpSession.getAttribute("cart")){
			List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("numberitemcart", shoppingCarts.size());
			modelMap.addAttribute("shoppingcarts",shoppingCarts);
		}
		
		return "/frontend/cart";
	}
	
	/**
	 * Control user request to order items on their cart
	 * @param customername
	 * @param phone
	 * @param address
	 * @param typeshipping
	 * @param description
	 * @param httpSession
	 * @param orderattr
	 * @param redirectAttributes
	 * @return 
	 */
	@PostMapping(value="/shopping-cart/")
	public String getOrders( @RequestParam String customername,
			@RequestParam int phone,
			@RequestParam String address,  
			@RequestParam String typeshipping,
			@RequestParam String description,
			HttpSession httpSession,
			 @ModelAttribute Orders orderattr,
				RedirectAttributes redirectAttributes){
		
		if(null !=  httpSession.getAttribute("user")){
			
			if(null !=  httpSession.getAttribute("cart")){
				List<ShoppingCart>shoppingCarts = (List<ShoppingCart>) httpSession.getAttribute("cart");
				Orders orders = new Orders();
				orders.setCustomer_name(customername);
				orders.setPhone(phone);
				orders.setAddress(address);
				orders.setCreated_at(null);
				orders.setType_shipping(typeshipping);
				orders.setDescription(description);
				  
				int orderId = ordersService.addOrders(orders);  
				if(orderId > 0){
					Set<OrderDetails>listOrderDetails = new HashSet<OrderDetails>();
					for (ShoppingCart item : shoppingCarts) {
						
						OrderDetailsID detailsID = new OrderDetailsID();
						detailsID.setProduct_id(item.getProduct_id());
						detailsID.setOrder_id(orders.getOrder_id());
						
						OrderDetails orderDetails = new OrderDetails();
						orderDetails.setOderDetailsID(detailsID);
						orderDetails.setPayments(item.getPrice()*item.getQuanlity());
						orderDetails.setQuantity(item.getQuanlity());
						
						orderDetailsService.addOrderDetails(orderDetails);
					}
					redirectAttributes.addFlashAttribute("orderattr", orderattr);
					return "redirect:/shopping-cart/success/";
				}else
					return "/frontend/cart";
			} 
		}else{
			return "redirect:/login/";
		}
		
		return "/frontend/cart";
		
	}
	
	@RequestMapping(value="/shopping-cart/success/", method=RequestMethod.GET)
	public String orderSuccess(@ModelAttribute("orderattr") Orders orders) {
        // preview title groupbook.
		System.out.println("book title :" + orders.getCustomer_name()); 
		return "redirect:/";
	}
}
