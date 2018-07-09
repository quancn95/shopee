 <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Home</title>
<jsp:include page="header.jsp"></jsp:include>
<script>
		$(function(){
			$('#products').slides({
				preload: true,
				preloadImage: 'img/loading.gif',
				effect: 'slide, fade',
				crossfade: true,
				slideSpeed: 350,
				fadeSpeed: 500,
				generateNextPrev: true,
				generatePagination: false
			});
		});
	</script>
</head>
<body>
	<div class="wrap">
		<jsp:include page="top.jsp"></jsp:include>
		
 <div class="main">
    <div class="content">
    	<div class="content_top">
    		<div class="back-links">
    		<p><a href="index.html">Home</a> >>>> <a href="#">Electronics</a></p>
    	    </div>
    		<div class="clear"></div>
    	</div>
    	<div class="section group">
				<div class="cont-desc span_1_of_2">
				  <div class="product-details">				
					<div class="grid images_3_of_2">
						<div id="container">
						   <div id="products_example">
							   <div id="products">
								<div class="slides_container">
									<a href="#" target="_blank"><img id="productimage" data-img="/resources/image/uploads/${preview.getImage() }" src='<c:url value = "/resources/image/uploads/${preview.getImage() }"/>' alt=" " /></a>
									<%-- <a href="#" target="_blank"><img src='<c:url value = "/resources/image/productslide-2.jpg"/>' alt=" " /></a>
									<a href="#" target="_blank"><img src='<c:url value = "/resources/image/productslide-3.jpg"/>' alt=" " /></a>					
									<a href="#" target="_blank"><img src='<c:url value = "/resources/image/productslide-4.jpg"/>' alt=" " /></a>
									<a href="#" target="_blank"><img src='<c:url value = "/resources/image/productslide-5.jpg"/>' alt=" " /></a>
									<a href="#" target="_blank"><img src='<c:url value = "/resources/image/productslide-6.jpg"/>' alt=" " /></a> --%>
								</div>
								<%-- <ul class="pagination">
									<li><a href="#"><img src='<c:url value = "/resources/image/thumbnailslide-1.jpg"/>' alt=" " /></a></li>
									<li><a href="#"><img src='<c:url value = "/resources/image/thumbnailslide-2.jpg"/>' alt=" " /></a></li>
									<li><a href="#"><img src='<c:url value = "/resources/image/thumbnailslide-3.jpg"/>' alt=" " /></a></li>
									<li><a href="#"><img src='<c:url value = "/resources/image/thumbnailslide-4.jpg"/>' alt=" " /></a></li>
									<li><a href="#"><img src='<c:url value = "/resources/image/thumbnailslide-5.jpg"/>' alt=" " /></a></li>
									<li><a href="#"><img src='<c:url value = "/resources/image/thumbnailslide-6.jpg"/>' alt=" " /></a></li>
								</ul> --%>
							</div>
						</div>
					</div>
				</div>
				<div class="desc span_3_of_2">
					<h2 id="productname" data-id="${preview.getProduct_id()}">${preview.getName() }</h2>
					<p>${preview.getDescription() }</p>					
					<div class="price">
						<p>Price: <span id="productprice" class="prod-price" data-price="${preview.getPrice() }">${preview.getPrice() } đ</span></p>
					</div>
					<div class="available">
						<p>Available Options :</p>
							<table class="table">
								<tr>
									<th>Model</th>
									<th>Available</th>
									<th>Quality</th>
									<th></th>
								</tr>
								<tr>
									<td class="tr_model" data-model="${preview.getModel() }">${preview.getModel() }</td>
									<td class="tr_quantity" data-quantity="${preview.getQuantity() }">${preview.getQuantity() }</td>
									<td class="tr_number"><select id="selectquantity">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select></td>
									<td> 					
										<h4><a class="btn_Add_Cart">Add to Cart</a></h4>
										<!-- <button class="btn_Add_Cart">Add to Cart</button> -->
									</td>
								</tr>
							</table>
								
					<!-- <ul>
						<li>Color:
							<select>
							<option>Silver</option>
							<option>Black</option>
							<option>Dark Black</option>
							<option>Red</option>
						</select></li>
						<li>Size:<select>
							<option>Large</option>
							<option>Medium</option>
							<option>small</option>
							<option>Large</option>
							<option>small</option>
						</select></li>
						<li>Quality:<select>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select></li>
					</ul> -->
					</div>
				<%-- <div class="share-desc">
					<div class="share">
						<p>Share Product :</p>
						<ul>
					    	<li><a href="#"><img src='<c:url value = "/resources/image/facebook.png"/>' alt="" /></a></li>
					    	<li><a href="#"><img src='<c:url value = "/resources/image/twitter.png"/>' alt="" /></a></li>					    
			    		</ul>
					</div> 
					<div class="clear"></div>
				</div>
				 <div class="wish-list">
				 	<ul>
				 		<li class="wish"><a href="#">Add to Wishlist</a></li>
				 	    <li class="compare"><a href="#">Add to Compare</a></li>
				 	</ul>
				 </div> --%>
			</div>
			<div class="clear"></div>
		  </div>
		<div class="product_desc">	
			<div class="resp-tabs-container descript-container">
				<h3>Product Details</h3>
					<div class="product-desc">
						<p>${preview.getDesciption_detail() }</p>
						<!-- <p>Lorem Ipsum is simply dummy text of the <span>printing and typesetting industry</span>. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, <span>when an unknown printer took a galley of type and scrambled</span> it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.<span> It has survived not only five centuries</span>, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p> -->					
					</div>
			</div>	
			<%-- <div id="horizontalTab">
				<ul class="resp-tabs-list">
					<li>Product Details</li>
					<li>product Tags</li>
					<li>Product Reviews</li>
					<div class="clear"></div>
				</ul>
				<div class="resp-tabs-container">
					<div class="product-desc">
						<p>Lorem Ipsum is simply dummy text of the <span>printing and typesetting industry</span>. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, <span>when an unknown printer took a galley of type and scrambled</span> it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.<span> It has survived not only five centuries</span>, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>					
						</div>

				 <div class="product-tags">
						 <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
					<h4>Add Your Tags:</h4>
					<div class="input-box">
						<input type="text" value="">
					</div>
					<div class="button"><span><a href="#">Add Tags</a></span></div>
			    </div>	

				<div class="review">
					<h4>Lorem ipsum Review by <a href="#">Finibus Bonorum</a></h4>
					 <ul>
					 	<li>Price :<a href="#"><img src='<c:url value = "/resources/image/price-rating.png"/>' alt="" /></a></li>
					 	<li>Value :<a href="#"><img src='<c:url value = "/resources/image/value-rating.png"/>' alt="" /></a></li>
					 	<li>Quality :<a href="#"><img src='<c:url value = "/resources/image/quality-rating.png"/>' alt="" /></a></li>
					 </ul>
					 <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
				  <div class="your-review">
				  	 <h3>How Do You Rate This Product?</h3>
				  	  <p>Write Your Own Review?</p>
				  	  <form>
					    	<div>
						    	<span><label>Nickname<span class="red">*</span></label></span>
						    	<span><input type="text" value=""></span>
						    </div>
						    <div><span><label>Summary of Your Review<span class="red">*</span></label></span>
						    	<span><input type="text" value=""></span>
						    </div>						
						    <div>
						    	<span><label>Review<span class="red">*</span></label></span>
						    	<span><textarea> </textarea></span>
						    </div>
						   <div>
						   		<span><input type="submit" value="SUBMIT REVIEW"></span>
						  </div>
					    </form>
				  	 </div>				
				</div>
			</div>
		 </div> --%>
	 </div>
	    <script type="text/javascript">
    $(document).ready(function () {
        $('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion           
            width: 'auto', //auto or any width like 600px
            fit: true   // 100% fit in a container
        });
    });
   </script>		
   <div class="content_bottom">
    		<div class="heading">
    		<h3>Related Products</h3>
    		</div>
    		<div class="see">
    			<p><a href="/FrameWorkOriented/all-product">See all Products</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
   <div class="section group">
				<c:forEach var="related" items="${relatedProduct }">
					<div class="grid_1_of_4 images_1_of_4">
						 <a href="/FrameWorkOriented/preview-${related.getProduct_id() }"><img src='<c:url value = "/resources/image/uploads/${related.getImage() }"/>' alt=""></a>					
						<div class="price" style="border:none">
						       		<div class="add-cart" style="float:none">								
										<h4><a href="/FrameWorkOriented/preview-${related.getProduct_id() }">See More...</a></h4>
								     </div>
								 <div class="clear"></div>
						</div>
					</div>
				</c:forEach>
				 
				 
			</div>
        </div>
				<div class="rightsidebar span_3_of_1">
					<h2>CATEGORIES</h2>
					<ul class="side-w3ls">
				      <c:forEach var="categoryList" items="${categories }">
				      		<li><a href="/FrameWorkOriented/cate-${categoryList.getCategory_id() }">${categoryList.getName() }</a></li>
				      </c:forEach>
    				</ul>
    				<!-- <div class="subscribe">
    					<h2>Newsletters Signup</h2>
    						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod.......</p>
						    <div class="signup">
							    <form>
							    	<input type="text" value="E-mail address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'E-mail address';"><input type="submit" value="Sign up">
							    </form>
						    </div>
      				</div> -->
      				 <!-- <div class="community-poll">
      				 	<h2>Community POll</h2>
      				 	<p>What is the main reason for you to purchase products online?</p>
      				 	<div class="poll">
      				 		<form>
      				 			<ul>
									<li>
									<input type="radio" name="vote" class="radio" value="1">
									<span class="label"><label>More convenient shipping and delivery </label></span>
									</li>
									<li>
									<input type="radio" name="vote" class="radio" value="2">
									<span class="label"><label for="vote_2">Lower price</label></span>
									</li>
									<li>
									<input type="radio" name="vote" class="radio" value="3">
									<span class="label"><label for="vote_3">Bigger choice</label></span>
									</li>
									<li>
									<input type="radio" name="vote" class="radio" value="5">
									<span class="label"><label for="vote_5">Payments security </label></span>
									</li>
									<li>
									<input type="radio" name="vote" class="radio" value="6">
									<span class="label"><label for="vote_6">30-day Money Back Guarantee </label></span>
									</li>
									<li>
									<input type="radio" name="vote" class="radio" value="7">
									<span class="label"><label for="vote_7">Other.</label></span>
									</li>
									</ul>
      				 		</form>
      				 	</div>
      				 </div> -->
 				</div>
 		</div>
 	</div>
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