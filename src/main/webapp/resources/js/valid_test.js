/**
 * 
 */$(document).ready(function(){
		$flag=1;
    	$("#myName").focusout(function(){
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_name").text("* You have to enter your first name!");
        	}
        	else
        	{
        		$(this).css("border-color", "#2eb82e");
        		$('#submit').attr('disabled',false);
        		$("#error_name").text("");

        	}
       });
        $("#lastname").focusout(function(){
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_lastname").text("* You have to enter your Last name!");
        	}
        	else
        	{
        		$(this).css("border-color", "#2eb82e");
        		$('#submit').attr('disabled',false);
        		$("#error_lastname").text("");
        	}
       });
        $("#dob").focusout(function(){
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_dob").text("* You have to enter your Date of Birth!");
        	}
        	else
        	{
        		$(this).css("border-color", "#2eb82e");
        		$('#submit').attr('disabled',false);
        		$("#error_dob").text("");
        	}
       });
        $("#gender").focusout(function(){
        	$(this).css("border-color", "#2eb82e");
       
       });
        $("#age").focusout(function(){
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_age").text("* You have to enter your Age!");
        	}
        	else
        	{
        		$(this).css({"border-color":"#2eb82e"});
        		$('#submit').attr('disabled',false);
        		$("#error_age").text("");

        	}
        	});
        $("#phone").focusout(function(){
            $pho =$("#phone").val();
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_phone").text("* You have to enter your Phone Number!");
        	}
        	else if ($pho.length!=10)
        	{   
                    $(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_phone").text("* Lenght of Phone Number Should Be Ten");
        	}
        	else if(!$.isNumeric($pho))
        	{
        	        $(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_phone").text("* Phone Number Should Be Numeric");  
        	}
        	else{
        		$(this).css({"border-color":"#2eb82e"});
        		$('#submit').attr('disabled',false);
        		$("#error_phone").text("");
        	}

    	});

   		$( "#submit" ).click(function() {
   			if($("#myName" ).val()=='')
   			{
        		$("#myName").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_name").text("* You have to enter your first name!");
        	}
        	if($("#lastname" ).val()=='')
   			{
        		$("#lastname").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_lastname").text("* You have to enter your Last name!");
        	}
   			if($("#dob" ).val()=='')
   			{
        		$("#dob").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_dob").text("* You have to enter your Date of Birth!");
        	}
   			if($("#age" ).val()=='')
   			{
        		$("#age").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_age").text("* You have to enter your Age!");
        	}
        	if($("#phone" ).val()=='')
   			{
        		$("#phone").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_phone").text("* You have to enter your Phone Number!");
        	}
			});
 
    	
	});
 
 /////////////////////////////////////
 $('#username').on('blur', function(){
	  var currval = $(this).val();
	 
	  if(currval.length < 6) {
	    $(this).next('.errmsg').slideDown();
	  } else {
	    // the username is 6 or more characters and we hide the error
	    $(this).next('.errmsg').slideUp();
	  }
	});
	 
	$('#email').on('blur', function(){
	  // email regex source http://stackoverflow.com/a/17968929/477958
	  var mailval = $(this).val();
	 
	  var pattern = new RegExp(/^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/);
	  if(!pattern.test(mailval)) {
	    $(this).next('.errmsg').slideDown();
	  } else {
	    $(this).next('.errmsg').slideUp();
	  }
	});
	 
	$('#password2').on('blur', function(){
	  var pwone = $('#password1').val();
	  var pwtwo = $(this).val();
	 
	  if(pwtwo.length < 1 || pwone != pwtwo) {
	    $(this).next('.errmsg').slideDown();
	  } else if(pwone == pwtwo) {
	    // both passwords match and we hide the error
	    $(this).next('.errmsg').slideUp();
	  }
	});
	
	
/*	[   ^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$   ]
		This regex will enforce these rules: 
		At least one upper case English letter, (?=.*?[A-Z])
		At least one lower case English letter, (?=.*?[a-z])
		At least one digit, (?=.*?[0-9])
		At least one special character, (?=.*?[#?!@$%^&*-])
		Minimum eight in length .{8,} (with the anchors) */
	
	/* [a-zA-Z]* should contain only character */
	
	function validateEmail(email) {
		  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		  return re.test(email);
		}

		function validate() {
		  var $result = $("#result");
		  var email = $("#email").val();
		  $result.text("");

		  if (validateEmail(email)) {
		    $result.text(email + " is valid :)");
		    $result.css("color", "green");
		  } else {
		    $result.text(email + " is not valid :(");
		    $result.css("color", "red");
		  }
		  return false;
		}

		$("#validate").bind("click", validate);
		
		// remember me
		$(function() {
			 
            if (localStorage.chkbx && localStorage.chkbx != '') {
                $('#remember_me').attr('checked', 'checked');
                $('#username').val(localStorage.usrname);
                $('#pass').val(localStorage.pass);
            } else {
                $('#remember_me').removeAttr('checked');
                $('#username').val('');
                $('#pass').val('');
            }

            $('#remember_me').click(function() {

                if ($('#remember_me').is(':checked')) {
                    // save username and password
                    localStorage.usrname = $('#username').val();
                    localStorage.pass = $('#pass').val();
                    localStorage.chkbx = $('#remember_me').val();
                } else {
                    localStorage.usrname = '';
                    localStorage.pass = '';
                    localStorage.chkbx = '';
                }
            });
        });