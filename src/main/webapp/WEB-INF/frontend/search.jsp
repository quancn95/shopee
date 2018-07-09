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
<%-- 	<table>
		<c:forEach var="item" items="${listsearch }">
			<tr>
				<td>${item.getName() }</td>
				<td>${item.getQuantity() }</td>
				<td>${item.getModel() }</td>
			</tr>
		</c:forEach>
		
	</table> --%>
	
	<div class="main"> 
			<div class="section group common-prod">
				<div class="row_result">
					<div class="col-md-12 found_search_result">Found ${listsearch.size() } results</div>
				</div>
				 <c:forEach var="item" items="${listsearch }">
				 	<div class="grid_1_of_4 images_1_of_4">
						 <a href="/FrameWorkOriented/preview-${item.getProduct_id() }"> <img class="prod-img" data-img="/resources/image/uploads/${item.getImage() }" src='<c:url value = "/resources/image/uploads/${item.getImage() }"/>' alt="" /></a>
						<a href="/FrameWorkOriented/preview-${item.getProduct_id() }"> <h2 class="prod-name" style="font-size: 1em;">${item.getName() }</h2></a>
						<div class="price-details">
					       <div class="price-number">
								<p style="color:red; font-size: 1em;"> 
									<span class="rupees prod-price" style="color:red; font-size: 1.7em;">${item.getPrice() }</span> ₫</p>
						    </div>
						       		 
								 <div class="clear"></div>
						</div> 
					</div>
				 </c:forEach>
			</div>
	</div>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
		<jsp:include page="footer.jsp"></jsp:include>
	 

</body>
</html>