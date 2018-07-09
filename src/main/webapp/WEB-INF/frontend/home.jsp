<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	

	<div class="container-fluid">
		<div class="row">
			<div id="cot1" class="col-md-3"></div>
			<div class="col-md-3">
				
			</div>
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<c:choose>
					<c:when test="${username != null}"> 
						<a href="/FrameWorkOriented/login/">
							<img alt="avatar" src="<c:url value = "/resources/image/${avatar}"/>" style="width: 30px;height: 30px;border-radius: 50px; float: left; margin-top: -8px;"/>
						</a>
						<a href="/FrameWorkOriented/login/">${username}</a>
						<a href="/FrameWorkOriented/logout">Logout</a>
					</c:when>
					<c:otherwise>
						<a href="/FrameWorkOriented/login/" id="account" class="account">Login Now </a>
					</c:otherwise>
				</c:choose>
				 
			</div>
		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>