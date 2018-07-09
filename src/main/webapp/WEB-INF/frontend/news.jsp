<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Search</title>
</head>
<body>
	<div class="wrap">
		<jsp:include page="top.jsp"></jsp:include> 
		
	<div class="main"> 
		 <div class="content">
    	<div class="image group">
				<div class="grid images_3_of_1">
					<img src='<c:url value = "/resources/image/uploads/newsimg1.jpg"/>' alt="" />
				</div>
				<div class="grid news_desc">
					<h3>Lorem Ipsum is simply dummy text </h3>
					<h4>Posted on Aug 13th, 2013 by <span><a href="#">Finibus Bonorum</a></span></h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur <a href="#" title="more">[....]</a></p>
			   </div>
		   </div>	
		   <div class="image group">
				<div class="grid images_3_of_1">
					<img src='<c:url value = "/resources/image/uploads/newsimg2.jpg"/>' alt="" />
				</div>
				<div class="grid news_desc">
					<h3>Lorem Ipsum is simply dummy text </h3>
					<h4>Posted on Aug 8th, 2013 by <span><a href="#">Finibus Bonorum</a></span></h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur <a href="#" title="more">[....]</a></p>
			   </div>
		   </div>
		   <div class="image group">
				<div class="grid images_3_of_1">
					<img src='<c:url value = "/resources/image/uploads/newsimg3.jpg"/>' alt="" />
				</div>
				<div class="grid news_desc">
					<h3>Lorem Ipsum is simply dummy text </h3>
					<h4>Posted on Aug 1st, 2013 by <span><a href="#">Finibus Bonorum</a></span></h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur <a href="#" title="more">[....]</a></p>
			   </div>
		   </div>
		   <div class="content-pagenation">
						<li><a href="#">Frist</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><span>....</span></li>
						<li><a href="#">Last</a></li>
						<div class="clear"> </div>
					</div>	
         </div> 
    </div>	
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
		<jsp:include page="footer.jsp"></jsp:include>
	  

</body>
</html>