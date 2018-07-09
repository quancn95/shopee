<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%-- <jsp:include page="header.jsp"></jsp:include> --%>
</head>
<body>
<div id="myModal" class="modal"> 
	  <!-- Modal content -->
	  <div class="modal-content-loading"> 
	  	<img alt="" src="<c:url value = "/resources/image/gifs/35.gif"/>">
	  </div> 
	</div> 
		<div class="header">
			<div class="headertop_desc">
				<div class="call">
					<p>
						<span>Need help?</span> call us <span class="number">1-22-3456789</span></span>
					</p>
				</div>
				<div class="account_desc">
					<ul>
						<c:choose>
							<c:when test="${username != null}">
								<li><a href="/FrameWorkOriented/login/"> <img
										alt="avatar"
										src="<c:url value = "/resources/image/uploads/${avatar}"/>"
										style="width: 30px; height: 30px; border-radius: 50px; float: left; margin-top: -5px;" />
								</a> <a href="/FrameWorkOriented/login/">${username}</a></li>
								<li><a href="/FrameWorkOriented/logout">Logout</a></li>
								<li><a href="#">Delivery</a></li>
								<li><a href="#">Checkout</a></li>
								<li><a href="#">My Account</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/FrameWorkOriented/signup/">Register</a></li>
								<li><a href="/FrameWorkOriented/login/">Login</a></li>
								<li><a href="#">Delivery</a></li>
								<li><a href="#">Checkout</a></li>
								<li><a href="#">My Account</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<div class="header_top">
				<div class="logo">
					<a href="/FrameWorkOriented/"><img alt=""
						src='<c:url value = "/resources/image/logo.png"/>' /></a>
				</div>
				<div class="cart">
					<p>
						Welcome to our Online Store! &nbsp&nbsp <a
							href="/FrameWorkOriented/shopping-cart/"><span>Cart:</span></a>
					<div id="dd" class="wrapper-dropdown-2">
						<span>${numberitemcart }</span> item(s) - $0.00
						<ul class="dropdown">
							<li>you have no items in your Shopping cart</li>
						</ul>
					</div>
					</p>
				</div>
				<script type="text/javascript">
					function DropDown(el) {
						this.dd = el;
						this.initEvents();
					}
					DropDown.prototype = {
						initEvents : function() {
							var obj = this;
		
							obj.dd.on('click', function(event){
								$(this).toggleClass('active');
								event.stopPropagation();
							});	
						}
					}
		
					$(function() { 
						var dd = new DropDown( $('#dd') ); 
						$(document).click(function() {
							// all dropdowns
							$('.wrapper-dropdown-2').removeClass('active');
						});
		
					});

				</script>
				<div class="clear"></div>
			</div>
			<div class="header_bottom">
				<div class="menu">
					<ul>
						<li class="active"><a href="/FrameWorkOriented/">Home</a></li>
						<li><a href="/FrameWorkOriented/about-us">About</a></li>
						<li><a href="/FrameWorkOriented/delivery">Delivery</a></li>
						<li><a href="/FrameWorkOriented/news">News</a></li>
						<li><a href="/FrameWorkOriented/contact">Contact</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="search_box">
					<form method="get" action="/FrameWorkOriented/search">
						<input type="text" value="Search" name="keyword"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Search';}"><input
							type="submit" value="">
					</form>
				</div>
				<div class="clear"></div>
			</div>
			<div class="header_slide">
				<div class="header_bottom_left">
					<div class="categories">
						<ul>
							<h3>Categories</h3>
							<c:forEach var="categoryList" items="${categories }">
								<li><a
									href="/FrameWorkOriented/cate-${categoryList.getCategory_id() }">${categoryList.getName() }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="header_bottom_right">
					<div class="slider">
						<div id="slider">
							<div id="mover">
								<div id="slide-1" class="slide">
									<div class="slider-img">
										<a href="preview.html"><img
											src='<c:url value = "/resources/image/uploads/slide-1-image.png"/>'
											alt="learn more" /></a>
									</div>
									<div class="slider-text">
										<h1>
											Clearance<br>
											<span>SALE</span>
										</h1>
										<h2>UPTo 20% OFF</h2>
										<div class="features_list">
											<h4>Get to Know More About Our Memorable Services Lorem
												Ipsum is simply dummy text</h4>
										</div>
										<a href="preview.html" class="button">Shop Now</a>
									</div>
									<div class="clear"></div>
								</div>
								<div class="slide">
									<div class="slider-text">
										<h1>
											Clearance<br>
											<span>SALE</span>
										</h1>
										<h2>UPTo 40% OFF</h2>
										<div class="features_list">
											<h4>Get to Know More About Our Memorable Services</h4>
										</div>
										<a href="preview.html" class="button">Shop Now</a>
									</div>
									<div class="slider-img">
										<a href="preview.html"><img
											src='<c:url value = "/resources/image/uploads/slide-3-image.jpg"/>'
											alt="learn more" /></a>
									</div>
									<div class="clear"></div>
								</div>
								<div class="slide">
									<div class="slider-img">
										<a href="preview.html"><img
											src='<c:url value = "/resources/image/uploads/slide-2-image.jpg"/>'
											alt="learn more" /></a>
									</div>
									<div class="slider-text">
										<h1>
											Clearance<br>
											<span>SALE</span>
										</h1>
										<h2>UPTo 10% OFF</h2>
										<div class="features_list">
											<h4>Get to Know More About Our Memorable Services Lorem
												Ipsum is simply dummy text</h4>
										</div>
										<a href="preview.html" class="button">Shop Now</a>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	
			<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
</body>
</html>