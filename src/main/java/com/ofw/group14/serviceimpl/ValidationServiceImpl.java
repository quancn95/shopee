package com.ofw.group14.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @author VS9X64bit
 * class Service implement interface Sercvice
 */
@Service
public class ValidationServiceImpl {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_PASSWORD_REGEX = 
		    Pattern.compile("^[a-zA-Z\\d]{6,30}$", Pattern.CASE_INSENSITIVE); // "((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_+,?-]).{8,30})"

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
	}
	public static boolean validatePassWord(String password) {
		Matcher matcher = VALID_PASSWORD_REGEX .matcher(password);
        return matcher.find();
	}
	
	public boolean checkLength(String username, int a, int b){ 
		if(username.trim().length() > a && username.trim().length()< b ){ 
			 return true;
		}
		return false;
	}
	
	
	public String validUserName(String username){  
		String Validation = username.trim(); 
		if(Validation!=""){  
			if(checkLength(Validation, 4, 30)){  
				if(userServiceImpl.checkUserExists(Validation)==true){ 
					Validation= "That username is taken. Try another.";
				}else
					Validation= "";
			}else
				Validation="Please user between 5 to 30 characters.";
		}else
			Validation="You can't leave this empty.";
		
		return Validation;
	}
	
	public String validEmailAddress(String email){  
		String Validation = email.trim(); 
		if(Validation!=""){ 
			if(validateEmail(Validation)){
				if(userServiceImpl.checkEmailExists(Validation)==true){
					Validation= "That email address already exists. Try another.";
				}else
					Validation= "";
			}else
				Validation="Your email address not valid."; 
		}else
			Validation="You can't leave this empty.";
		  
		return Validation;
	}
	
	public String validPassWord(String password){  
		String Validation = password.trim(); 
		if(Validation==""){ 
			Validation="You can't leave this empty.";
		}else if(!checkLength(Validation, 6, 30)){
			Validation="Short passwords are easy to guess. Try one with at least 6 character.";
		} else if(!validatePassWord(Validation)){ 
			Validation="Your password not valid.";
		} else
			Validation= "";
		
		return Validation;
	}
	
	public String validPassWordAgian(String password,String repassword){  
		String Validation ="These passwords don't match. Try again?";
		if(repassword.equals(password)){
			Validation ="";
		}
		return Validation;
	}
	
	
	private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 6) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

   /* public static String MD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];
        md.update(text.getBytes("utf-8"), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }*/
	
	public static String MD5Crypt(String str){
		if(str == null || str.length() == 0){
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			StringBuffer hexStr = new StringBuffer();
			for(int i = 0; i< hash.length; i++){
				if((0xff & hash[i]) < 0x10){
					hexStr.append("0" + Integer.toHexString((0xff & hash[i])));
				}else{
					hexStr.append(Integer.toHexString((0xff & hash[i])));
				}
			}
			return hexStr.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String generate(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException 
    {
        MessageDigest md = MessageDigest.getInstance("SHA1");
            md.reset();
            byte[] buffer = input.getBytes("UTF-8");
            md.update(buffer);
            byte[] digest = md.digest();

            String hexStr = "";
            for (int i = 0; i < digest.length; i++) {
                hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
            }
            return hexStr;
    }
}
