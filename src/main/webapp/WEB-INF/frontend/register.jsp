<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 wrap-login">
				<form class="form-signup" action="" method="Post">
					<h3>Sign up</h3>
					<div class="form-group">
						<p style="color:red; font-size:11px;">${checkregister }</p>
						<label for="exampleInputEmail1">User name</label> 
						<input name="username"  class="form-control username" id="exampleInputUserName"
							value="${usercontain }"	aria-describedby="emailHelp" placeholder="Enter user name"> 
						<small id="errormsg_UserName" class="errormsg">${errorUserName}</small>
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">Email</label> 
						<input name="email" type="email" class="form-control" id="exampleInputEmail1"
							value="${emailcontain }"	aria-describedby="emailHelp" placeholder="Enter email">
							<small id="emailHelp" class="form-text text-alert">We'll never
							share your email with anyone else.</small> 
							<small id="errormsg_EmailAddress" class="errormsg">${errorEmailAddress}</small>
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> 
						<input name="password" type="password" class="form-control" id="exampleInputPassword1"
							value="${passcontain }"	placeholder="Password">
						<small id="errormsg_Passwd" class="errormsg">${errorPasswd}</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Confirm Password</label> 
						<input name="repassword" type="password" class="form-control" id="exampleInputPassword2"
							value="${repasscontain }" placeholder="Confirm Password">
						<small id="errormsg_PasswdAgain" class="errormsg">${errorPasswdAgain}</small>
					</div>
					<!-- <div class="form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check me
							out</label>
					</div> -->
					<button type="submit" class="btn btn-primary" id="btnSignup" 
						name="signup">Sign up</button>  
					<br>
					<a href="/FrameWorkOriented/login/">I have an account, Login now</a>
					<div class="clr"></div>
				</form>
			</div>
		</div> 
	</div>
	
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>