<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>Spring MVC Email Example</title>
	    <style type="text/css">
	    	#emailFormDiv {
	    		text-align: center;
    			padding-top: 16px;
	    	}
	    	
    		#emailFormPage {
    			text-decoration: none;
    			text-align: center;
    			cursor: pointer;
    		}
    		
    		#successMessage {
    			text-align: center; 
    			color: green; 
    			font-size: 25px; 
    			padding-top: 17px;
    		}
    	</style>
	</head>
	
	<body>
		<div class="wrap">
		 	<jsp:include page="top.jsp"></jsp:include>
		    <center>
		    	<h2>Spring MVC Email Example</h2>
		    </center>
		    <div id="successMessage">
		        <strong>${messageObj}</strong>
		    </div>
		    <div id="emailFormDiv">
		    	<a id="emailFormPage" href="emailForm">Go To Email Form Page</a>
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