$(document).ready(function(){
	$("#cot1").click(function(){
		alert("Helo");
		$(this).addClass("actived");
	});
	
	// register valid client side
	/**
	 * input username focusout
	 */
	$("#exampleInputUserName").focusout(function(){
		valid_username();
	});
	/**
	 * function valid input usename
	 * @returns
	 */
	function valid_username(){
		var inputusername = $("#exampleInputUserName");
		if(inputusername.val().trim()==''){
			inputusername.css("border-color", "#FF0000"); 
    			$("#errormsg_UserName").css("color", "#FF0000"); 
    			 $("#errormsg_UserName").text("* You have to enter your username.");
    			 return false;
    	}
    	else
    	{ 
    		/*$(this).css("border-color","#ced4da");
    		$("#errormsg_UserName").text("");*/
    		var username = inputusername.val(); 
    		check_username(username);
    			 
    		
    	}
	}; 
	function check_username(username){ 
		$.ajax({
			url:"/FrameWorkOriented/api/checkusername",
			type:"Get",
			data:{
				username:username
			},
			success:function(value){ 
				if(value=="true"){
					$("#exampleInputUserName").css("border-color", "#FF0000"); 
	    			$("#errormsg_UserName").css("color", "#FF0000"); 
	    			$("#errormsg_UserName").text("* That username is taken. Try another."); 
				}else{
					$("#exampleInputUserName").css("border-color","#ced4da");
		    		$("#errormsg_UserName").text(""); 
				}
			}
			
		}); 
	};
	
	/**
	 * input email address focusout
	 */
	var emailpattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; 
	$("#exampleInputEmail1").focusout(function(){
		valid_email();
	});
	
	/**
	 * function valid input email address
	 * @returns
	 */
	function valid_email(){
		var email_add = $("#exampleInputEmail1");
		if(email_add.val().trim()==''){
			email_add.css("border-color", "#FF0000"); 
			$("#errormsg_EmailAddress").css("color", "#FF0000"); 
			$("#errormsg_EmailAddress").text("* Choose a email address. ex:...");
			return false;
		}else if(!emailpattern.test(email_add.val().trim())){
			email_add.css("border-color","#FF0000");
			$("#errormsg_EmailAddress").css("color", "#FF0000"); 
			$("#errormsg_EmailAddress").text("* Your email address not valid.");
			return false;
		}else{
			var email = email_add.val();
			check_email(email);
		}
	};
	
	function check_email(email) {
		$.ajax({
			url:"/FrameWorkOriented/api/checkemail",
			type:"GET",
			data:{
				email:email
			},
			success:function(value){
				if(value=="true"){
					$("#exampleInputEmail1").css("border-color","#FF0000");
					$("#errormsg_EmailAddress").css("color", "#FF0000"); 
					$("#errormsg_EmailAddress").text("* That email already exist. Try another.");
					 
				}else{
					$("#exampleInputEmail1").css("border-color","#CED4DA");
					$("#errormsg_EmailAddress").css("color","#6c757d");
					$("#errormsg_EmailAddress").text("");
					 
				}
			}
		});
	};
	
	/**
	 * input password focusout
	 */
	$("#exampleInputPassword1").focusout(function() {
		valid_passwd();
	});
	
	/**
	 * fuction valid input password
	 * @returns
	 */
	function valid_passwd(){
		var passwd = $("#exampleInputPassword1");
		if(passwd.val()==''){
			passwd.css("border-color", "#FF0000"); 
			$("#errormsg_Passwd").css("color","#FF0000");
			$("#errormsg_Passwd").text("* Enter a password");
			return false;
		}else if(passwd.val().trim().length < 6){
			$(this).css("border-color", "#FF0000"); 
			$("#errormsg_Passwd").css("color","#FF0000");
			$("#errormsg_Passwd").text("* Use 6 characters or more for your password.");
			return false;
		}else{
			passwd.css("border-color","#CED4DA");
			$("#errormsg_Passwd").text("");
			return true;
		}
	};
	
	/**
	 * input passwd again focusout
	 */
	$("#exampleInputPassword2").focusout(function() {
		valid_repasswd();
	});
	
	/**
	 * function valid input password agian
	 * @returns
	 */
	function valid_repasswd(){
		var repasswd =$("#exampleInputPassword2");
		if(repasswd.val().trim() != $("#exampleInputPassword1").val()){
			repasswd.css("border-color", "#FF0000"); 
			$("#errormsg_PasswdAgain").css("color","#FF0000");
			$("#errormsg_PasswdAgain").text("* Thoose passwords didn't match. Try again.");
			return false;
		}else{
			repasswd.css("border-color","#CED4DA");
			$("#errormsg_PasswdAgain").text("");
			return true;
		}
	};
	
	/**
	 * form.form-signup submit
	 */
	$('.form-signup').submit(function(e){
		valid_username();
		valid_email();
		valid_passwd();
		valid_repasswd();
		
		var us_errmsg = $("#errormsg_UserName").text();
		var em_errmsg = $("#errormsg_EmailAddress").text();
		var pass_errmsg = $("#errormsg_Passwd").text();
		var repass_errmsg = $("#errormsg_PasswdAgain").text();
		if(us_errmsg != ""){
			$("#exampleInputUserName").focus();
			e.preventDefault();
		}else if(em_errmsg!=""){
			$("#exampleInputEmail1").focus();
			e.preventDefault();
		}else if(pass_errmsg!=""){
			$("#exampleInputPassword1").focus();
			e.preventDefault();
		}else if(repass_errmsg!=""){
			$("#exampleInputPassword2").focus();
			e.preventDefault();
		}/*else
			$(this).submit(); */
	});
	 
	 
	/**
	 * user sign up ajax
	 */
	/*$("#btnSignup").click(function() {
		var username = $("#exampleInputUserName").val();
		var email = $("#exampleInputEmail1").val();
		var password = $("#exampleInputPassword1").val();
		var repassword = $("#exampleInputPassword2").val(); 
		$.ajax({
	    	url:"/FrameWorkOriented/api/signup",
	    	type:"GET",
	    	data:{
	    		username:username,
	    		email:email,
	    		password:password,
	    		repassword:repassword
	    	},
	    	success:function(value){
	    		alert(value);
	    	}
	    })
	});*/
	
 
	
	/**
	 * check exists user set timeout
	 */
	/*var x_timer;
	$("#exampleInputUserName").keyup(function (e) {
		clearTimeout(x_timer);
		var user_name = $(this).val();
		x_timer = setTimeout(function () {
			check_username(user_name);
		},500);
	});
	
	function check_username(username){
		$("#user_result").html(''); 
		$.ajax({
	    	url:"/FrameWorkOriented/api/checkusername",
	    	type:"GET",
	    	data:{
	    		username:username 
	    	},
	    	success:function(value){
	    		if(value=="true"){   
	    			$("#user_result").text("Da ton tai")	
	    		}else{ 
	    			$("#user_result").text("Co the su dung")	
	    		}
	    	}
	    })
	}*/
	
	/**
	 * sticky menu srolling
	 */
	menu_pos = $(".header").position().top + $(".header").outerHeight(true);
	$(window).scroll(function(){
		scroll_pos = $(document).scrollTop();
		if(parseInt(scroll_pos) > parseInt(menu_pos)){
			$(".header_scroll").addClass("fixed").slideDown();
		}else{
			$(".header_scroll").removeClass("fixed").hide();
		}
	});
	
	/**
	 * side navigation
	 */
	$(".open_sidenav").click(function(){ 
		$(".scrollnav").toggleClass('nav-view');
		$("#outSidenav").toggleClass('outsidenav');
		$("body").addClass("overflow_position");
	});
	
	$("#outSidenav").click(function(event){
		if(!$(event.target).is('.scrollnav'))
		{
			$(".scrollnav").toggleClass('nav-view');
			$("#outSidenav").toggleClass('outsidenav'); 
			$("body").removeClass("overflow_position");
		}else {
			$(".close_sidenav").click(function(){ 
				$(".scrollnav").toggleClass('nav-view');
				$("#outSidenav").toggleClass('outsidenav');
				$("body").removeClass("overflow_position");
			});
		}
		
	});
	
	
	/**
	 * Add to cart
	 */ 
	$("body").on("click",".btn_Add_Cart_Custom",function(){
		var id = $(this).closest(".images_1_of_4").find(".prod-name").attr("data-id");
		var image = $(this).closest(".images_1_of_4").find(".prod-img").attr("data-img");
		var model = $(this).closest(".images_1_of_4").find(".price-details").attr("data-model"); 
		var quantity = $(this).closest(".images_1_of_4").find(".price-number").attr("data-availble");
		var number = 1;
		var name = $(this).closest(".images_1_of_4").find(".prod-name").text();
		var price = $(this).closest(".images_1_of_4").find('.prod-price').attr("data-price");   
		//alert(id+" "+image+" "+model+" "+quantity+" "+number+" "+name+" "+price);
		$.ajax({
	    	url:"/FrameWorkOriented/api/addtocart",
	    	type:"GET",
	    	data:{
	    		prodid:id,
	    		prodimage:image,
	    		prodname:name,
	    		prodprice:price,
	    		prodmodel:model,
	    		prodquantity:quantity,
	    		prodnumber:number
	    	},
	    	success:function(value){
	    		 
	    	}
	    }).done(function() {
	    	$.ajax({
		    	url:"/FrameWorkOriented/api/number-items-cart",
		    	type:"GET", 
		    	success:function(value){
		    		 $(".wrapper-dropdown-2").html("<span>"+value+"</span>"+" item(s) - $0.00");
		    		 $(".noti_cart a span").addClass("num_itemcart").text(value); 
		    	}
		    })
		});
	});
	
	$(".btn_Add_Cart").click(function() {
		/*$(this).parent().parent() hoac $(this).closest()
		 * var model = $(this).closest("tr").find(".tr_model").attr("data-model");
		 * */
		var id = $("#productname").attr("data-id");
		var image = $("#productimage").attr("data-img");
		var model = $(this).closest("tr").find(".tr_model").text(); 
		var quantity = $(this).closest("tr").find(".tr_quantity").text();
		var number = $(this).closest("tr").find("#selectquantity option:selected").text();
		var name = $("#productname").text();
		var price = $('#productprice').attr('data-price');   
		$.ajax({
	    	url:"/FrameWorkOriented/api/addtocart",
	    	type:"GET",
	    	data:{
	    		prodid:id,
	    		prodimage:image,
	    		prodname:name,
	    		prodprice:price,
	    		prodmodel:model,
	    		prodquantity:quantity,
	    		prodnumber:number
	    	},
	    	success:function(value){
	    		 
	    	}
	    }).done(function() {
	    	$.ajax({
		    	url:"/FrameWorkOriented/api/number-items-cart",
		    	type:"GET", 
		    	success:function(value){
		    		 $(".wrapper-dropdown-2").html("<span>"+value+"</span>"+" item(s) - $0.00");
		    		 $(".noti_cart a span").addClass("num_itemcart").text(value);  
		    		 
		    	}
		    })
		}); 
		 
	});
	
	/**Format price
	 * @returns
	 */
	function getPayMent(){ 
		var payment = 0;
		$(".tr_price").each(function(){
			var price = $(this).closest("tr").find(".tr_price").attr("data-price");
			var number = $(this).closest("tr").find(".prodnumber").val();
			var sumprice = parseInt(price)*number;
			var format = FormatNumber(sumprice+""); 
			$(this).html(format);    
			payment = payment + sumprice; 
			var formatpm = FormatNumber(payment+""); 
			$("#payment").html(formatpm+" đ"); 
			
			
		});
		var a = $(".tr_price").length; 
		if(a == 0){ 
			$("#payment").text("0 đ"); 
		} 
		$(".prod-price").each(function(){
			var pricetext = $(this).text();
			var formatpr = FormatNumber(pricetext);
			$(this).text(formatpr);
		});
		
		/**
		 *  sub menu
		 */
		str = $("#str_username").text();
		res = str.substring(0,1).toUpperCase();
		$("#first_user").text(res);
		
		/*ni = parseInt($(".num_itemcart").text());
		if(ni < 1){
			$(".noti_cart a span").removeClass("num_itemcart").text(""); 
		}else{
			$(".noti_cart a span").addClass("num_itemcart");
		}*/
	}
	getPayMent();
	
	
	
	/*function formatCurrency(){  
		$(".prod-price").each(function(){
			var formatpr = FormatNumber($(".prod-price").text());
			$(".prod-price").text(formatpr);
		});
	}
	formatCurrency();*/
	/**
	 * number item change
	 */
	$(".prodnumber").change(function(){
		var number = $(this).val();
		var price = $(this).closest("tr").find(".tr_price").attr("data-price");
		var sumprice = number*parseInt(price);
		//var format = sumprice.toFixed(0).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		var format = FormatNumber(sumprice+""); 
		$(this).closest("tr").find(".tr_price").html(sumprice);
		getPayMent();
		
		var id = $(this).closest("tr").find(".tr_name").attr("data-id");
		var model = $(this).closest("tr").find(".tr_model").text(); 
		$.ajax({
	    	url:"/FrameWorkOriented/api/update-shopping-cart",
	    	type:"GET",
	    	data:{
	    		prodid:id, 
	    		prodmodel:model, 
	    		prodnumber:number
	    	},
	    	success:function(value){
	    		 
	    	}
	    })
		 
	}); 
	 /**
	  * delete item from cart
	  */
	$(".btn-delete").click(function(){
		$(".modal").show();
		var process = $(this);
		var id = $(this).closest("tr").find(".tr_name").attr("data-id");
		var model = $(this).closest("tr").find(".tr_model").text(); 
		$.ajax({
	    	url:"/FrameWorkOriented/api/remove-shopping-cart",
	    	type:"GET",
	    	data:{
	    		prodid:id, 
	    		prodmodel:model 
	    	},
	    	success:function(value){
	    		process.closest("tr").remove(); 
	    		getPayMent();
	    		$(".modal").hide();
	    	}
	    }).done(function() {
	    	$.ajax({
		    	url:"/FrameWorkOriented/api/number-items-cart",
		    	type:"GET", 
		    	success:function(value){
		    		 $(".wrapper-dropdown-2").html("<span>"+value+"</span>"+" item(s) - $0.00"); 
		    		 if(value < 1)
		    			 $(".noti_cart a span").removeClass("num_itemcart").text("");
		    		 else
		    			 $(".num_itemcart").text(value); 
		    	}
		    })
		}); 
	    
	});
	/**
	 * Format accurency
	 * @param str
	 * @returns
	 */
	function FormatNumber(str) {
		var strTemp = GetNumber(str);
		if (strTemp.length <= 3)
			return strTemp;
		strResult = "";
		for (var i = 0; i < strTemp.length; i++)
			strTemp = strTemp.replace(",", "");
		var m = strTemp.lastIndexOf(".");
		if (m == -1) {
			for (var i = strTemp.length; i >= 0; i--) {
				if (strResult.length > 0 && (strTemp.length - i - 1) % 3 == 0)
					strResult = "," + strResult;
				strResult = strTemp.substring(i, i + 1) + strResult;
			}
		} else {
			var strphannguyen = strTemp.substring(0, strTemp.lastIndexOf("."));
			var strphanthapphan = strTemp.substring(strTemp.lastIndexOf("."),
					strTemp.length);
			var tam = 0;
			for (var i = strphannguyen.length; i >= 0; i--) {

				if (strResult.length > 0 && tam == 4) {
					strResult = "," + strResult;
					tam = 1;
				}

				strResult = strphannguyen.substring(i, i + 1) + strResult;
				tam = tam + 1;
			}
			strResult = strResult + strphanthapphan;
		}
		return strResult;
	}

	function GetNumber(str) {
		var count = 0;
		for (var i = 0; i < str.length; i++) {
			var temp = str.substring(i, i + 1);
			if (!(temp == "," || temp == "." || (temp >= 0 && temp <= 9))) {
				alert(inputnumber);
				return str.substring(0, i);
			}
			if (temp == " ")
				return str.substring(0, i);
			if (temp == ".") {
				if (count > 0)
					return str.substring(0, ipubl_date);
				count++;
			}
		}
		return str;
	}

	function IsNumberInt(str) {
		for (var i = 0; i < str.length; i++) {
			var temp = str.substring(i, i + 1);
			if (!(temp == "." || (temp >= 0 && temp <= 9))) {
				alert(inputnumber);
				return str.substring(0, i);
			}
			if (temp == ",") {
				return str.substring(0, i);
			}
		}
		return str;
	} 
	
	/**
	 * paging dashboard
	 */
	$("body").on("click",".page_index ",function(){
		$(".page_index").removeClass("active");
		$(this).addClass("active");
		var pageindex = $(this).text();
		var total = 5;
		var at = ( pageindex - 1) * total;
		$.ajax({
			url: "/FrameWorkOriented/api/manage-pagination",
			type: "get",
			data:{
				at:at,
				total:total
			},success: function(value){
				var tbody_prod = $("#table-product").find("tbody");
				tbody_prod.empty();
				tbody_prod.append(value);
			}
		});
	});
	
	/**
	 * paging loadmore return html
	 */
	/*var is_busy = false;
	var var_page = 2;
	$("body").on("click","#btn_loadmore", function(){ 
		var_page++;
		var cateid = $(".prod-cate").attr("data-cate");
		var total = 8;
		var at = (var_page -1 )* total; 
		
		if(is_busy == true){
			return false;
		}
		
		$.ajax({
			url: "/FrameWorkOriented/api/loadmore",
			type: "get",
			data:{
				cateid:cateid,
				at:at,
				total:total
			},success: function(value){
				if(!$.trim(value)){
					$("#btn_loadmore").remove(); 
				}else
					$(".section_product").append(value); 
				
			}
		}).always(function()
        { 
            is_busy = false;
        });
	});*/
	/**
	 * paging loadmore return json
	 */
	var is_busy = false;
	var var_page = 2;
	$("body").on("click","#btn_loadmore", function(){ 
		var_page++;
		var cateid = $(".prod-cate").attr("data-cate");
		var total = 8;
		var at = (var_page -1 )* total; 
		
		if(is_busy == true){
			return false;
		}
		$(this).hide();
		$("#btn_loading").show();
		
		$.ajax({
			url: "/FrameWorkOriented/api/load-more-json",
			dataType: "json",
			type: "post",
			data:{
				cateid:cateid,
				at:at,
				total:total
			},success: function(value){ 
				var html = "";
				if(value.length <= total){
					$.each(value, function(key, obj) {
						html += "<div class='grid_1_of_4 images_1_of_4'>"; 
						html += "<a href=\"/FrameWorkOriented/preview-"+obj.product_id+"\"> ";
						html += "<img class='prod-img' data-img='/resources/image/uploads/"+obj.image+"' src=\"/FrameWorkOriented/resources/image/uploads/"+obj.image+"\" alt=\"\" /></a>";
						html += "<h2 class='prod-name' data-id='"+obj.product_id+"'>"+obj.name+"</h2>";
						html += "<a class='prod-cate' data-cate='"+obj.categories.category_id+"'></a>";
						html += "<div class='price-details' data-model='"+obj.model+"'>";
						html += " <div class='price-number' data-availble='"+obj.quantity+"'>";
						html += "<p><span class='rupees prod-price' data-price='"+obj.price+"'>"+obj.price+"</span>đ</p>";
						html += " </div>";
						html += "<div class='add-cart'>	";
						html += "<h4><a class='btn_Add_Cart_Custom'>Add to Cart</a></h4>";
						html += "</div>";
						html += "<div class='clear'></div>";
						html += "</div>";
						html += "</div>";
					});
					$(".section_product").append(html); 
					$("#btn_loading").fadeOut(3000);
					$("#btn_loadmore").remove(); 
				}else{ 
					$.each(value, function(key, obj) {
						if(key < value.length-1){
							html += "<div class='grid_1_of_4 images_1_of_4'>"; 
							html += "<a href=\"/FrameWorkOriented/preview-"+obj.product_id+"\"> ";
							html += "<img class='prod-img' data-img='/resources/image/uploads/"+obj.image+"' src=\"/FrameWorkOriented/resources/image/uploads/"+obj.image+"\" alt=\"\" /></a>";
							html += "<h2 class='prod-name' data-id='"+obj.product_id+"'>"+obj.name+"</h2>";
							html += "<a class='prod-cate' data-cate='"+obj.categories.category_id+"'></a>";
							html += "<div class='price-details' data-model='"+obj.model+"'>";
							html += " <div class='price-number' data-availble='"+obj.quantity+"'>";
							html += "<p><span class='rupees prod-price' data-price='"+obj.price+"'>"+obj.price+"</span>đ</p>";
							html += " </div>";
							html += "<div class='add-cart'>	";
							html += "<h4><a class='btn_Add_Cart_Custom'>Add to Cart</a></h4>";
							html += "</div>";
							html += "<div class='clear'></div>";
							html += "</div>";
							html += "</div>"; 
						}
					
					});
					$(".section_product").append(html); 
					$("#btn_loading").fadeOut();
					$("#btn_loadmore").fadeIn();
				} 
				
			}
		}).always(function()
        { 
            is_busy = false;
        });
	});
	
	
	/**
	 * delete table
	 */
	$("#btn_delete_mnt").click(function(){
		$("#table-product > tbody input:checked").each(function(){
			var productid = $(this).val();
			var process = $(this);
			$.ajax({
				url: "/FrameWorkOriented/api/manage-product-delete",
				type: "get",
				data:{
					productid:productid 
				},success: function(value){
					process.closest("tr").remove();
					$("#table_product_manage").load(location.href+" #table_product_manage>*","");
				}
			});
		})
	});
	/*
	 * check all checkbox
	 */
	$("#checkall").change(function(){
		if($("#checkall").is(':checked')){  
			/*$("#table-product input").each(function(){
				$(this).attr("checked","checked"); 
			});*/
			$("input:checkbox").prop('checked', true);
		}else{
			$("#table-product input").each(function(){
				$(this).prop('checked', false);
			});
		}
	}); 
	
	/**
	 * upload img
	 */
	var files = [];
	var imagefile = "";
	$("#inputimage").change(function(event){
		files = event.target.files; 
		imagefile = files[0].name;
		forms = new FormData();
		forms.append("file", files[0]); 
		$.ajax({
			url: "/FrameWorkOriented/api/upload-file",
			type: "post",
			data:forms,
			contentType:false,
			processData:false,
			enctype:"multipart/form-data",
			success: function(value){
			
			}
		});
	});
	
	/**
	 * Add new Product
	 */
	$("#btn-addProd").click(function(event){
		event.preventDefault();
		json = {};
		var formdata = $("#form-product").serializeArray();
		$.each(formdata, function(i, field){
			json[field.name] = field.value;
			/*if(field.name === "categories"){
				objectCategory = {};
				objectCategory["category_id"] = field.value;
				json[field.name] = objectCategory;
			}
			if(field.name === "brands"){
				objectBrand = {};
				objectBrand["brand_id"] = field.value;
				json[field.name] = objectBrand; 
			}*/
		})
		json["image"] = imagefile;
		$.ajax({
			url: "/FrameWorkOriented/api/add-new-product",
			type: "post",
			data:{
				dataJson:JSON.stringify(json)
			},
			success: function(value){
				$("#table_product_manage").load(location.href+" #table_product_manage>*","");
			}
		}); 
	});
	
	
	/**
	 * load form to update
	 */
	var idproduct = 0;
	$("body").on("click", ".btn_loadFormUpdate", function(){
		$("#btn-cancel").removeClass("hidden");
		$("#btn-updateProd").removeClass("hidden");
		$("#btn-addProd").addClass("hidden");
		
		idproduct = $(this).attr("data-id");
		$.ajax({
			url: "/FrameWorkOriented/api/select-product-by-identity",
			type: "post",
			data:{
				idproduct:idproduct
			},
			success: function(value){ 
				$("#inputprodname").val(value.name);
				$("#inputmodel").val(value.model);
				$("#inputconfig").val(value.configuration);
				$("#inputquantity").val(value.quantity);
				$("#inputyear").val(value.created_at);
				$("#inputprice").val(value.price);
				$("#tadesciption").val(value.description);
				$("#tacontent").val(value.desciption_detail);
				$("#selectcategory").val(value.categories.category_id);
				$("#selectbrand").val(value.brands.brand_id);
				$("#selectfeatured").val(value.featured);
			}
		}); 
	}) ;
	
	/**
	 * update product selected
	 */
	$("#btn-updateProd").click(function(){
		event.preventDefault();
		json = {};
		var formdata = $("#form-product").serializeArray();
		$.each(formdata, function(i, field){
			json[field.name] = field.value;
			 
		})
		json["product_id"] = idproduct;
		json["image"] = imagefile;
		$.ajax({
			url: "/FrameWorkOriented/api/update-selected-product-by-identity",
			type: "post",
			data:{
				dataJson:JSON.stringify(json)
			},
			success: function(value){
				$("#table_product_manage").load(location.href+" #table_product_manage>*","");
			}
		});  
	});
	
	$("#btn-cancel").click(function(event){ 
		event.preventDefault();
		$("#btn-addProd").removeClass("hidden");
		$("#btn-updateProd").addClass("hidden");
		$(this).addClass("hidden");
		$("#form-product").trigger("reset");
	});
})






