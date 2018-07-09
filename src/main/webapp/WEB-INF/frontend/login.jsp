<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Login</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
 
	<div class="container-fluid">
		<div class="row">
			<a href="/FrameWorkOriented/en/login">EN </a> 
			<a href="/FrameWorkOriented/vi/login">VI</a> 
			<div class="col-md-4 wrap-login">
				<form class="form-login" action="" method="POST" >
					<h3> <spring:message    code="label.title" /></h3> 
					<div class="form-group">
						<p style="color:red; font-size:11px;">${checklogin }</p>
						<label for="exampleInputEmail1"> <spring:message    code="label.userName" /></label>  
						<input name="tendangnhap" class="form-control" id="exampleInputUserName"
							aria-describedby="" placeholder="Enter user name">
						<!-- <input name="tendangnhap" type="email" class="form-control" id="exampleInputEmail1"
							aria-describedby="" placeholder="Enter user name">  -->
						<small id="exampleInputUserName" class="form-text text-alert"></small>
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1"><spring:message    code="label.password" /></label>  
						<input name="matkhau" type="password" class="form-control" id="exampleInputPassword1"
						autocomplete="new-password">
					</div>
					
					<!-- <div class="form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check me
							out</label>
					</div> -->
					
					
					<button type="submit" class="btn btn-primary"> <spring:message code="label.submit"/></button>
					
					<br>
					<a href="/FrameWorkOriented/signup/">Don't have account, Register now</a>
					<div class="clr"></div>
				</form>
			</div>
		</div> 
	</div>
	
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>