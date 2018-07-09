<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Home</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	
	<div class="wrap">
	<jsp:include page="top.jsp"></jsp:include>
	
 <div class="main">
 	<div class="leftsidebar span_3_of_1">
					<h2>CATEGORIES</h2>
					<ul class="side-w3ls">
				      <c:forEach var="categoryList" items="${categories }">
				      		<li><a href="/FrameWorkOriented/cate-${categoryList.getCategory_id() }">${categoryList.getName() }</a></li>
				      </c:forEach>
    				</ul>
    </div>
    <div class="content_allproduct">
    	<div class="content_top"> 
    			<span><a href="/FrameWorkOriented/all-product">Products |</a></span>  
    			<span><a href="/FrameWorkOriented/cate-${categoryList.getCategory_id() }">${categoryList.getName() }</a></span>
    	</div>
	      <div class="section group section_product"> 
				 <c:forEach var="cateProducts" items="${cateProducts }">
				 	<div class="grid_1_of_4 images_1_of_4">
						<a href="/FrameWorkOriented/preview-${cateProducts.getProduct_id() }"> 
						 	<img class="prod-img" data-img="/resources/image/uploads/${cateProducts.getImage() }" src='<c:url value = "/resources/image/uploads/${cateProducts.getImage() }"/>' alt="" /></a>
						<h2 class="prod-name" data-id="${cateProducts.getProduct_id() }">${cateProducts.getName() }</h2>
						<a class="prod-cate" data-cate="${cateProducts.getCategories().getCategory_id() }"></a>
						<div class="price-details" data-model="${cateProducts.getModel() }">
					    <div class="price-number" data-availble="${cateProducts.getQuantity() }">
							<p><span class="rupees prod-price" data-price="${cateProducts.getPrice() }">${cateProducts.getPrice() } </span>đ</p>
						</div>
			       		<div class="add-cart">								
							<h4><a class="btn_Add_Cart_Custom">Add to Cart</a></h4>
						</div>
						<div class="clear"></div>
						</div> 
					</div>
				 </c:forEach>
			</div> 
			
			<div class="pagingnation">
				<div id="btn_loadmore" class="loadmore">
					<span>Load more</span>
				</div>
				
				<div id="btn_loading" class="loadmore"> 
					<div class="growing-dots">
						<span>L</span>
						<span>o</span>
						<span>a</span>
						<span>d</span>
						<span>i</span>
						<span>n</span>
						<span>g</span>
						<span>.</span>
						<span>.</span>
						<span>.</span>
						<!-- <ul>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
						</ul>	 -->
					</div>
					<div class="clear"></div>
				</div>
				 
			</div>
    </div>
    <div class="clear"></div>
 </div>
</div>
   <div class="footer">
   	  <div class="wrap">	
	     <div class="section group">
				<div class="col_1_of_4 span_1_of_4">
						<h4>Information</h4>
						<ul>
						<li><a href="about.html">About Us</a></li>
						<li><a href="contact.html">Customer Service</a></li>
						<li><a href="#">Advanced Search</a></li>
						<li><a href="delivery.html">Orders and Returns</a></li>
						<li><a href="contact.html">Contact Us</a></li>
						</ul>
					</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Why buy from us</h4>
						<ul>
						<li><a href="about.html">About Us</a></li>
						<li><a href="contact.html">Customer Service</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="contact.html">Site Map</a></li>
						<li><a href="#">Search Terms</a></li>
						</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>My account</h4>
						<ul>
							<li><a href="contact.html">Sign In</a></li>
							<li><a href="index.html">View Cart</a></li>
							<li><a href="#">My Wishlist</a></li>
							<li><a href="#">Track My Order</a></li>
							<li><a href="contact.html">Help</a></li>
						</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Contact</h4>
						<ul>
							<li><span>+91-123-456789</span></li>
							<li><span>+00-123-000000</span></li>
						</ul>
						<div class="social-icons">
							<h4>Follow Us</h4>
					   		  <ul>
							      <li><a href="#" target="_blank"><img src='<c:url value = "/resources/image/facebook.png"/>' alt="" /></a></li>
							      <li><a href="#" target="_blank"><img src='<c:url value = "/resources/image/twitter.png"/>' alt="" /></a></li>
							      <li><a href="#" target="_blank"><img src='<c:url value = "/resources/image/skype.png"/>' alt="" /> </a></li>
							      <li><a href="#" target="_blank"> <img src='<c:url value = "/resources/image/dribbble.png"/>' alt="" /></a></li>
							      <li><a href="#" target="_blank"> <img src='<c:url value = "/resources/image/linkedin.png"/>' alt="" /></a></li>
							      <div class="clear"></div>
						     </ul>
   	 					</div>
				</div>
			</div>			
        </div>
        <div class="copy_right">
				<p>&copy; 2013 home_shoppe. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
		   </div>
    </div>
    <script type="text/javascript">
    $(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>