<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Top</title>
<jsp:include page="header.jsp"></jsp:include>
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
									</a> 
									<a id="str_username" href="/FrameWorkOriented/login/">${username}</a></li>
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
			
			<div class="header_scroll">
				<div class="menu_left">
					<ul>
						<li>
				 			<span class="open_sidenav" style="font-size:20px;cursor:pointer;color: gray;font-weight: 600;" >&#9776;</span>
				 		</li>
						<li> 
							<a href="/FrameWorkOriented/"><img alt=""
								src='<c:url value = "/resources/image/logo.png"/>' /></a>
				 		</li>
				 			<div class="clear"></div>
					</ul>
					
					<div id="outSidenav" class="">
						<div class="scrollnav">
							<div id="mySidenav" class="sidenav">
							   
							 			
								<div class="sidenav_top">
									<div class="sidenav_back">
										<span class="close_sidenav" style="font-size:20px;cursor:pointer;color: gray;font-weight: 600;" >&#9776;</span></div>
									<div class="sidenav_back">
										<a href="/FrameWorkOriented/"><img alt=""
											src='<c:url value = "/resources/image/logo.png"/>' /></a>
									</div>
									<div class="clear"></div>
								</div>
								
							  <a href="#">Services</a>
							  <!-- <a href="#">About</a>
							  <a href="#">Services</a>
							  <a href="#">Clients</a>
							  <a href="#">Contact</a> -->
							</div> 
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="menu_center">
					<div class="search_box_scroll">
						<form method="get" action="/FrameWorkOriented/search">
							<input type="text" value="Search" name="keyword"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Search';}"><input
								type="submit" value="">
						</form>
					</div>
				</div>
				<div class="menu_right">
					<ul>
						
						<c:choose>
							<c:when test="${username != null}">
								<li>
									<%-- <a href="/FrameWorkOriented/login/">
										<img  alt="avatar" src="<c:url value = "/resources/image/uploads/${avatar}"/>"
										style="width: 30px; height: 30px; border-radius: 50px; float: left; margin-top: -5px;" />
									</a> --%> 
									<div class="menu_notification noti_cart">
										<a href="/FrameWorkOriented/login/">
											<span id="first_user"></span>
										</a>
									</div>
								</li> 
							</c:when>
							<c:otherwise> 
								<li><a href="/FrameWorkOriented/login/">
									<span style="color:red;font-weight:bold;padding-top:5px;display: block;">Sign In</span></a></li> 
							</c:otherwise>
						</c:choose>
						<li>
							<div class="menu_notification noti_cart">
							<a href="/FrameWorkOriented/shopping-cart/"><img
										alt="cart"
										src="<c:url value = "/resources/image/shopping-cart.png"/>"
										style="width: 25px; height: 28px;" /> 
								  
									<c:choose>
										<c:when test="${numberitemcart > 0}">
											<span class="num_itemcart">${numberitemcart }</span> 
										</c:when>
										<c:otherwise>
											<span class=""></span>
										</c:otherwise>
									</c:choose>
									 
							</a> 
							</div>
						</li>
						<li>
							<div class="menu_notification noti_sub">
							<a href="/FrameWorkOriented/shopping-cart/"><img
										alt="cart"
										src="<c:url value = "/resources/image/bell-notification.png"/>"
										style="width: 25px; height: 28px;" /> 
									<span ></span> 
							</a> 
							</div>
						</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</body>
</html>