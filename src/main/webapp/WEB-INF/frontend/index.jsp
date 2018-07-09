<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Home</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body> 
<div class="wrap"> 
 	<jsp:include page="topbanner.jsp"></jsp:include>
	
	<div class="main">
    <div class="content">
    	<div class="content_top">
    		<div class="heading">
    		<h3>New Products</h3>
    		</div>
    		<div class="see">
    			<p><a href="/FrameWorkOriented/all-products">See all Products</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
    	
	      <div class="section group"> 
				 <c:forEach var="listNew" items="${newProducts }">
				 	<div class="grid_1_of_4 images_1_of_4">
						 <a href="/FrameWorkOriented/preview-${listNew.getProduct_id() }"> <img class="prod-img" data-img="/resources/image/uploads/${listNew.getImage() }" src='<c:url value = "/resources/image/uploads/${listNew.getImage() }"/>' alt="" /></a>
						 <h2 class="prod-name" data-id="${listNew.getProduct_id() }">${listNew.getName() }</h2>
						<div class="price-details" data-model="${listNew.getModel() }">
					       <div class="price-number" data-availble="${listNew.getQuantity() }">
								<p><span class="rupees prod-price" data-price="${listNew.getPrice() }">${listNew.getPrice() } </span>đ</p>
						    </div>
						       		<div class="add-cart">								
										<h4><a class="btn_Add_Cart_Custom">Add to Cart</a></h4>
								     </div>
								 <div class="clear"></div>
						</div> 
					</div>
				 </c:forEach>
			</div>
			<div class="content_bottom">
    		<div class="heading">
    		<h3>Common Products</h3>
    		</div>
    		<div class="see">
    			<p><a href="/FrameWorkOriented/all-products">See all Products</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
			<div class="section group common-prod">
				 <c:forEach var="listCommon" items="${commonProducts }">
				 	<div class="grid_1_of_4 images_1_of_4">
						 <a href="/FrameWorkOriented/preview-${listCommon.getProduct_id() }"> <img class="prod-img" data-img="/resources/image/uploads/${listCommon.getImage() }" src='<c:url value = "/resources/image/uploads/${listCommon.getImage() }"/>' alt="" /></a>
						 <h2 class="prod-name" data-id="${listCommon.getProduct_id() }">${listCommon.getName() }</h2>
						<div class="price-details" data-model="${listCommon.getModel() }">
					       <div class="price-number" data-availble="${listCommon.getQuantity() }">
								<p><span class="rupees prod-price" data-price="${listCommon.getPrice() }">${listCommon.getPrice() } </span>đ</p>
						    </div>
						       		<div class="add-cart">								
										<h4><a class="btn_Add_Cart_Custom">Add to Cart</a></h4>
								     </div>
								 <div class="clear"></div>
						</div> 
					</div>
				 </c:forEach>
			</div>
    </div>
 </div>
</div>
	
	<jsp:include page="bottom.jsp"></jsp:include>
   	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>