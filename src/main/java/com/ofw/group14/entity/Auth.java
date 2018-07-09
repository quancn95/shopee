package com.ofw.group14.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auth {
	
	   
	    public enum Role {
	        LOGIN, ADMIN, EMPLOYEE
	    };
	 
	    // khai báo properties cho anotation với giá trị mặc định là LOGIN
	    // ví dụ: @Auth(role = Role.LOGIN)
	    public Role role() default Role.LOGIN; // default = @Auth()
	 
}
