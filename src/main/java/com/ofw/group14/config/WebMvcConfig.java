package com.ofw.group14.config;

import com.ofw.group14.config.UrlLocaleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
 
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
 
       // Default..
   }
 
   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
   }
 
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
 
       UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor(); 
       registry.addInterceptor(localeInterceptor).addPathPatterns("/en/*", "/fr/*", "/vi/*");
       
       registry.addInterceptor(new AuthInterceptor()).excludePathPatterns("/login");
   }
 
}
