package com.microsoft.demo.azuremfaspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private @Autowired AutowireCapableBeanFactory beanFactory;
	
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
    
    
    @Bean
    public FilterRegistrationBean adalFilter(){
    	FilterRegistrationBean registration = new FilterRegistrationBean();
    	AdalFilter adalFilter = new AdalFilter();
    	beanFactory.autowireBean(adalFilter);
    	registration.setFilter(adalFilter);
    	registration.addUrlPatterns("/hello");
    	registration.setOrder(1);
    	return registration;
    }

    
}
