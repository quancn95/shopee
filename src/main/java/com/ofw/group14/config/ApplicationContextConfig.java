package com.ofw.group14.config;
 
import com.ofw.group14.config.UrlLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Configuration
@ComponentScan("com.ofw.group14.config.*")
public class ApplicationContextConfig {
 
   @Bean(name = "viewResolver")
   public InternalResourceViewResolver getViewResolver() {
       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
 
       viewResolver.setPrefix("/WEB-INF/pages/");
       viewResolver.setSuffix(".jsp");
 
       return viewResolver;
   }
  
   @Bean(name = "messageSource")
   public MessageSource getMessageResource()  {
       ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource(); 
  
      
       // Đọc vào file i18n/messages_xxx.properties
       // Ví dụ: i18n/message_en.properties
       messageResource.setBasename("classpath:i18n/messages");
       messageResource.setDefaultEncoding("UTF-8");
       return messageResource;
   }
 
 
   // To solver URL like:
   // /SpringMVCInternationalization/en/login2
   // /SpringMVCInternationalization/vi/login2
   // /SpringMVCInternationalization/fr/login2
   @Bean(name = "localeResolver")
   public LocaleResolver getLocaleResolver()  {
       LocaleResolver resolver= new UrlLocaleResolver();
       return resolver;
   }
  
 
}
