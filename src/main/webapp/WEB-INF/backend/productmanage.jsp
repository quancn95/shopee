<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web
	Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- Bootstrap Core CSS -->
<link href='<c:url value="/resources/pooled/css/bootstrap.min.css"/>'
	rel="stylesheet">
<!-- Custom CSS -->
<link href='<c:url value="/resources/pooled/css/style.css"/>'
	rel="stylesheet" type='text/css'>
<link href='<c:url value="/resources/pooled/css/morris.css"/>'
	rel="stylesheet" type='text/css'>
<!-- Graph CSS -->
<link href='<c:url value="/resources/pooled/css/font-awesome.css"/>'
	rel="stylesheet"> 
<!-- datepicker -->
<link href='<c:url value="/resources/bootstrap-4.0.0-dist/css/datepicker.css"/>'
	rel="stylesheet">
<!-- jQuery -->
<script src='<c:url  value="/resources/pooled/js/jquery-2.1.4.min.js"/>'>
	
</script>
<!-- //jQuery -->
<link
	href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link href='<c:url value="/resources/pooled/css/icon-font.min.css"/>'
	rel="stylesheet" type='text/css'>
<!-- //lined-icons -->

</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="mother-grid-inner">
				<!--header start here-->
				<div class="header-main">
					<div class="logo-w3-agile">
						<h1>
							<a href="index.html">Pooled</a>
						</h1>
					</div>
					<div class="w3layouts-left">

						<!--search-box-->
						<div class="w3-search-box">
							<form action="#" method="post">
								<input type="text" placeholder="Search..." required="">
								<input type="submit" value="">
							</form>
						</div>
						<!--//end-search-box-->
						<div class="clearfix"></div>
					</div>
					<div class="w3layouts-right">
						<div class="profile_details_left">
							<!--notifications of menu start -->
							<ul class="nofitications-dropdown">
								<li class="dropdown head-dpdn"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-envelope"></i><span
										class="badge">3</span></a>
									<ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>You have 3 new messages</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="user_img">
													<img alt=""
														src="<c:url value = "/resources/pooled/images/in11.jpg"/>">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li class="odd"><a href="#">
												<div class="user_img">
													<img alt=""
														src="<c:url value = "/resources/pooled/images/in10.jpg"/>">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li><a href="#">
												<div class="user_img">
													<img alt=""
														src="<c:url value = "/resources/pooled/images/in9.jpg"/>">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all messages</a>
											</div>
										</li>
									</ul></li>
								<li class="dropdown head-dpdn"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-bell"></i><span
										class="badge blue">3</span></a>
									<ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>You have 3 new notification</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="user_img">
													<img alt=""
														src="<c:url value = "/resources/pooled/images/in8.jpg"/>">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li class="odd"><a href="#">
												<div class="user_img">
													<img alt=""
														src="<c:url value = "/resources/pooled/images/in6.jpg"/>">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li><a href="#">
												<div class="user_img">
													<img alt=""
														src="<c:url value = "/resources/pooled/images/in7.jpg"/>">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all notifications</a>
											</div>
										</li>
									</ul></li>
								<li class="dropdown head-dpdn"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-tasks"></i><span
										class="badge blue1">9</span></a>
									<ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>You have 8 pending task</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Database update</span><span
														class="percentage">40%</span>
													<div class="clearfix"></div>
												</div>
												<div class="progress progress-striped active">
													<div class="bar yellow" style="width: 40%;"></div>
												</div>
										</a></li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Dashboard done</span><span
														class="percentage">90%</span>
													<div class="clearfix"></div>
												</div>
												<div class="progress progress-striped active">
													<div class="bar green" style="width: 90%;"></div>
												</div>
										</a></li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Mobile App</span><span
														class="percentage">33%</span>
													<div class="clearfix"></div>
												</div>
												<div class="progress progress-striped active">
													<div class="bar red" style="width: 33%;"></div>
												</div>
										</a></li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Issues fixed</span><span
														class="percentage">80%</span>
													<div class="clearfix"></div>
												</div>
												<div class="progress progress-striped active">
													<div class="bar  blue" style="width: 80%;"></div>
												</div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all pending tasks</a>
											</div>
										</li>
									</ul></li>
								<div class="clearfix"></div>
							</ul>
							<div class="clearfix"></div>
						</div>
						<!--notification menu end -->

						<div class="clearfix"></div>
					</div>
					<div class="profile_details w3l">
						<ul>
							<li class="dropdown profile_details_drop"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false">
									<div class="profile_img">
										<span class="prfil-img"><img alt=""
											src="<c:url value = "/resources/pooled/images/in4.jpg"/>">
										</span>
										<div class="user-name">
											<p>Malorum</p>
											<span>Administrator</span>
										</div>
										<i class="fa fa-angle-down"></i> <i class="fa fa-angle-up"></i>
										<div class="clearfix"></div>
									</div>
							</a>
								<ul class="dropdown-menu drp-mnu">
									<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
									<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
									<li><a href="#"><i class="fa fa-sign-out"></i> Logout</a>
									</li>
								</ul></li>
						</ul>
					</div>

					<div class="clearfix"></div>
				</div>
				<!--heder end here-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a> <i
						class="fa fa-angle-right"></i></li>
				</ol>

				<div class="row">
					<!-- left content -->
					<div class="col-md-6 col-sm-12">
						<form id="form-product" action="" method="post">
						  
							<div class="form-group col-md-12">
								<label for="inputprodname">Product</label>
								<input id="inputprodname" name="name" type="text" class="form-control" placeholder="Product"/>
				 			</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputmodel">Model</label> <input type="text"
										class="form-control" name="model" id="inputmodel" placeholder="Model">
								</div>
								<div class="form-group col-md-6">
									<label for="inputconfig">Configuration</label> <input
										type="text" class="form-control" id="inputconfig"
										name="configuration" placeholder="Configuration">
								</div>
							</div>
							
							<div class="form-row">
								<div class="form-group col-md-4">
									<label for="selectcategory">Category</label> <select id="selectcategory"
										name="categories" class="form-control">
											<option selected>Choose...</option>
										<c:forEach var="item" items="${categories }">
											<option value="${item.getCategory_id() }">${item.getName() }</option>
										</c:forEach>
										
									</select>
								</div>
								<div class="form-group col-md-4">
									<label for="selectbrand">Brand</label> <select id="selectbrand"
										name="brands" class="form-control">
											<option selected>Choose...</option>
										<c:forEach var="item" items="${brands }">
											<option value="${item.getBrand_id() }">${item.getName() }</option>
										</c:forEach>
										
									</select>
								</div>
								<div class="form-group col-md-4">
									<label for="selectfeatured">Featured</label> <select id="selectfeatured"
										name="featured" class="form-control">
										<option selected>Choose...</option>
										<c:forEach var="i" begin="0" end="5" >
											<option>${i }</option>
										</c:forEach>
										
									</select>
								</div>
							</div>
							
							<div class="form-group col-md-12">
								<label for="inputimage">Image</label> 
								<input type="file" name="image" class="form-control-file" id="inputimage">
							</div>
							
							<div class="form-row">
								<div class="form-group col-md-3">
									<label for="inputquantity">Quantity</label> <input type="number" min="1" value="1"
										name="quantity" class="form-control" id="inputquantity">
								</div>
								<div class="form-group col-md-4">
									<label for="inputyear">Prod.Year</label> 
									<input class="date-own form-control" name="created_at" id="inputyear" type="text">
								</div>
								<div class="form-group col-md-5">
									<label for="inputprice">Price</label> <input type="number" min="1000"
										name="price" class="form-control" id="inputprice">
								</div>
							</div>
							
							<div class="form-group col-md-12">
								<label for="tadesciption">Description</label> 
								<textarea name="description" class="form-control" id="tadesciption" rows="3"></textarea>
							</div>
							
							
							<div class="form-group col-md-12">
								<label for=""tacontent"">Content</label> 
								<textarea name="desciption_detail" class="form-control" id="tacontent" rows="5"></textarea>
							</div> 
							<div class="form-group col-md-12">
								<button type="submit" id="btn-addProd" class="btn btn-primary">Add new</button>
								<button type="submit" id="btn-updateProd" class="btn btn-primary hidden">Update</button>
								<button type="submit" id="btn-cancel" class="btn btn-primary hidden">Cancel</button>
						 	</div>
						</form>	
							 
							 
					</div>
					<!-- /end left -->
					<!-- right content -->
					<div class="col-md-6 col-sm-12">
						<!-- Content container -->
						<div class="col-md-sm-12 ">
							<div class="card">
								<div class="card-body">
									<div class="widget widget-report-table">
										<header class="widget-header m-b-15"> </header>

										<div class="row m-0 md-bg-grey-100 p-l-20 p-r-20">
											<div class="col-md-6 col-sm-6 col-xs-6 w3layouts-aug">
												<h3>August 2016</h3>
												<p>REPORT</p>
											</div>
											<div class="col-md-6 col-sm-6 col-xs-6 ">
												<h2 class="text-right c-teal f-300 m-t-20">$21,235</h2> 
												<button style="float:right;" id="btn_delete_mnt" class="btn">Delete</button>
											</div>
										</div>

										<div class="widget-body p-15" id="table_product_manage">
											<table id="table-product" class="table table-bordered">
												<thead>
													<tr>
														<th><input id="checkall" type="checkbox" value="" /></th>
														<th>Name</th>
														<th>Amount</th>
														<th>Price</th>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${listproductmnt }">
														<tr class="">
															<%-- <td><img class="tr_image"
														src='<c:url value = "${itemcart.getImage() }"/>'
														width="50px" height="55px;" alt="">
													</td> --%>

															<td><input class="select_item" type="checkbox"
																value="${item.getProduct_id() }" /></td>
															<td class="" data-id="${item.getProduct_id() }">${item.getName() }</td>
															<td class="">${item.getQuantity() }</td>
															<td class="">${item.getPrice() }</td>
															<td class="">
																<button class="btn_loadFormUpdate" data-id="${item.getProduct_id() }">Update</button>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<!-- Paging -->
											<ul class="pagination pagination-sm">
												<c:forEach var="i" begin="1" end="${allpagemnt }">

													<c:choose>
														<c:when test="${i==1}">
															<li class="page_index active"><a href="#">${i}</a></li>
														</c:when>
														<c:otherwise>
															<li class="page_index"><a href="#">${i}</a></li>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</ul>
											<!-- end paging -->

										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
						<!-- end content -->
					</div>
					
				</div>
				<!-- end row -->
				
				<!-- script for year picker -->
				 <script type="text/javascript">
					 $(document).ready(function() {
					      $('.date-own').datepicker({
					    	  viewMode: "years", 
					    	    minViewMode: "years",
					         format: 'yyyy'
					       });
					 });
				  </script>

				<!-- script-for sticky-nav -->
				<script>
					$(document).ready(function() {
						var navoffeset = $(".header-main").offset().top;
						$(window).scroll(function() {
							var scrollpos = $(window).scrollTop();
							if (scrollpos >= navoffeset) {
								$(".header-main").addClass("fixed");
							} else {
								$(".header-main").removeClass("fixed");
							}
						});

					});
				</script>
				<!-- /script-for sticky-nav -->
				<!--inner block start here-->
				<div class="inner-block"></div>
				<!--inner block end here-->
				<!--copy rights start here-->
				<div class="copyrights">
					<p>
						© 2016 Pooled. All Rights Reserved | Design by <a
							href="http://w3layouts.com/" target="_blank">W3layouts</a>
					</p>
				</div>
				<!--COPY rights end here-->
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo1">
				<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
				</a>
			</header>
			<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
			<div class="menu">
				<ul id="menu">
					<li><a href="/FrameWorkOriented/dashboard"><i
							class="fa fa-tachometer"></i> <span>Dashboard</span>
							<div class="clearfix"></div></a></li>


					<li id="menu-academico"><a href="inbox.html"><i
							class="fa fa-envelope nav_icon"></i><span>Inbox</span>
							<div class="clearfix"></div></a></li>
					<li><a href="gallery.html"><i class="fa fa-picture-o"
							aria-hidden="true"></i><span>Gallery</span>
							<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="charts.html"><i
							class="fa fa-bar-chart"></i><span>Charts</span>
							<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-list-ul" aria-hidden="true"></i><span> Short
								Codes</span> <span class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="icons.html">Icons</a></li>
							<li id="menu-academico-avaliacoes"><a href="typography.html">Typography</a></li>
							<li id="menu-academico-avaliacoes"><a href="faq.html">Faq</a></li>
						</ul></li>
					<li id="menu-academico"><a href="errorpage.html"><i
							class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error
								Page</span>
							<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i class="fa fa-cogs"
							aria-hidden="true"></i><span> UI Components</span> <span
							class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="button.html">Buttons</a></li>
							<li id="menu-academico-avaliacoes"><a href="grid.html">Grids</a></li>
						</ul></li>
					<li><a href="tabels.html"><i class="fa fa-table"></i> <span>Tables</span>
							<div class="clearfix"></div></a></li>
					<li><a href="maps.html"><i class="fa fa-map-marker"
							aria-hidden="true"></i> <span>Maps</span>
							<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-file-text-o"></i> <span>Pages</span> <span
							class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-boletim"><a href="calendar.html">Calendar</a></li>
							<li id="menu-academico-avaliacoes"><a href="signin.html">Sign
									In</a></li>
							<li id="menu-academico-avaliacoes"><a href="signup.html">Sign
									Up</a></li>


						</ul></li>
					<li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span>
							<span class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul>
							<li><a href="input.html"> Input</a></li>
							<li><a href="validation.html">Validation</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
	<!--js -->
	<script
		src='<c:url  value="/resources/pooled/js/jquery.nicescroll.js"/>'>
		
	</script>
	<script src='<c:url  value="/resources/pooled/js/scripts.js"/>'>
		
	</script>
	<!-- Bootstrap Core JavaScript -->
	<script src='<c:url  value="/resources/pooled/js/bootstrap.min.js"/>'>
		
	</script>
	<!-- /Bootstrap Core JavaScript -->
	<!-- morris JavaScript -->
	<script src='<c:url  value="/resources/pooled/js/raphael-min.js"/>'>
		
	</script>
	<!-- custom -->
	<script src='<c:url  value="/resources/js/custom.js"/>'> </script>
	<script src='<c:url  value="/resources/js/jquery-3.3.1.min.js"/>'> </script> 
	<script src='<c:url  value="/resources/bootstrap-4.0.0-dist/js/bootstrap-datepicker.js"/>'> </script> 
</body>
</html>