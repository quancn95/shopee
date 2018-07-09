
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
	$(function() {
		$('#products').slides({
			preload : true,
			preloadImage : 'img/loading.gif',
			effect : 'slide, fade',
			crossfade : true,
			slideSpeed : 350,
			fadeSpeed : 500,
			generateNextPrev : true,
			generatePagination : false
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
						<p>
							<a href="index.html">Home</a> | <a href="#">Electronics</a>
						</p>
					</div>
					<div class="clear"></div>
				</div>
				<div class="content_main">
					<div class="row">
						<div class="col-md-12">
							<div class="row_result">
								<div class="col-md-12 found_search_result">Your shopping cart</div>
							</div>
							<table class="table">
								<thead>
									<tr>
										<th>Image</th>
										<th>Product</th>
										<th>Model</th>
										<th>Available</th>
										<th>Quality</th>
										<th>Price</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="itemcart" items="${shoppingcarts }">
										<tr class="tr_rows">
											<td><img class="tr_image"
												src='<c:url value = "${itemcart.getImage() }"/>'
												width="50px" height="55px;" alt="">
											</td>
											<td class="tr_name" data-id="${itemcart.getProduct_id() }">${itemcart.getProductname() }</td>
											<td class="tr_model">${itemcart.getModel() }</td>
											<td class="tr_quantity">${itemcart.getAvailable() }</td>
											<td class="tr_number"><input type="number" class="prodnumber" min="1" max="10"
												value="${itemcart.getQuanlity() }" style="width: 75px;" /></td>
											<td class="tr_price" data-price="${itemcart.getPrice() }">${itemcart.getPrice() }</td>
											 
											<td style="padding: none;">
												<button class="btn btn-danger btn-delete">DELETE</button>
											</td>
										</tr> 
									</c:forEach>
								</tbody>
							</table>
							<h3 style="float:right;">Payment: <span style="color:red;" id="payment">0 đ</span></h3>
						</div>
					</div>

					<div class="row">
						<div class="col-md-12">
							<h3>Information payment</h3>
							<form action="" method="post">
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="customer">Customer</label> 
										<input type="text" class="form-control" name="customername" id="customer" placeholder="User">
									</div>
									<div class="form-group col-md-6">
										<label for="Phone">Phone</label> 
										<input type="text" class="form-control" name="phone" id="phone" placeholder="Phone">
									</div>
								</div>
								<div class="form-group">
									<label for="address">Address</label> 
									<input type="text" class="form-control" name="address" id="address"
										placeholder="1234 Main St">
								</div>
								<fieldset class="form-group">
									<div class="row">
										<legend class="col-form-label col-sm-2 pt-0">Radios</legend>
										<div class="col-sm-10">
											<div class="form-check">
												<input class="form-check-input" type="radio"
													name="typeshipping" id="gridRadios1" value="Online purchase" checked>
												<label class="form-check-label" for="gridRadios1">
													Online purchase </label>
											</div>
											<div class="form-check">
												<input class="form-check-input" type="radio"
													name="typeshipping" id="gridRadios2" value="Direct purchase">
												<label class="form-check-label" for="gridRadios2">
													Direct purchase </label>
											</div> 
										</div>
									</div>
								</fieldset>
								<!-- <div class="form-row">
									<div class="form-group col-md-6">
										<label for="inputCity">City</label> <input type="text"
											class="form-control" id="inputCity">
									</div>
									<div class="form-group col-md-4">
										<label for="inputState">State</label> <select id="inputState"
											class="form-control">
											<option selected>Choose...</option>
											<option>...</option>
										</select>
									</div>
									<div class="form-group col-md-2">
										<label for="inputZip">Zip</label> <input type="text"
											class="form-control" id="inputZip">
									</div>
								</div> -->
								<div class="form-group">
										<label for="inputDesciption">Desciption</label> 
										<textarea class="form-control" rows="5" name="description"
											 id="inputDesciption" placeholder="More detail..."></textarea>
									</div>
								<div class="form-group">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" id="gridCheck">
										<label class="form-check-label" for="gridCheck"> Check
											me out </label>
									</div>
								</div>
								<button type="submit" class="btn btn-primary">Submit</button>
							</form>
						</div>
					</div>
				</div>
				<div class="content_bottom">
					<div class="heading">
						<h3>Related Products</h3>
					</div>
					<div class="see">
						<p>
							<a href="/FrameWorkOriented/all-product">See all Products</a>
						</p>
					</div>
					<div class="clear"></div>
				</div>
				<div class="section group">
					<c:forEach var="related" items="${relatedProduct }">
						<div class="grid_1_of_4 images_1_of_4">
							<a href="/FrameWorkOriented/preview-${related.getProduct_id() }"><img
								src='<c:url value = "/resources/image/uploads/${related.getImage() }"/>'
								alt=""></a>
							<div class="price" style="border: none">
								<div class="add-cart" style="float: none">
									<h4>
										<a href="#">Add to Cart</a>
									</h4>
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</c:forEach>


				</div>
			</div>
			<%-- <div class="rightsidebar span_3_of_1">
					<h2>CATEGORIES</h2>
					<ul class="side-w3ls">
				      <c:forEach var="categoryList" items="${categories }">
				      		<li><a href="/FrameWorkOriented/cate-${categoryList.getCategory_id() }">${categoryList.getName() }</a></li>
				      </c:forEach>
    				</ul> 
 				</div> --%>
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
							<li><a href="#" target="_blank"><img
									src='<c:url value = "/resources/image/facebook.png"/>' alt="" /></a></li>
							<li><a href="#" target="_blank"><img
									src='<c:url value = "/resources/image/twitter.png"/>' alt="" /></a></li>
							<li><a href="#" target="_blank"><img
									src='<c:url value = "/resources/image/skype.png"/>' alt="" />
							</a></li>
							<li><a href="#" target="_blank"> <img
									src='<c:url value = "/resources/image/dribbble.png"/>' alt="" /></a></li>
							<li><a href="#" target="_blank"> <img
									src='<c:url value = "/resources/image/linkedin.png"/>' alt="" /></a></li>
							<div class="clear"></div>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="copy_right">
			<p>
				&copy; 2013 home_shoppe. All rights reserved | Design by <a
					href="http://w3layouts.com/">W3layouts</a>
			</p>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop"><span id="toTopHover"> </span></a>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>