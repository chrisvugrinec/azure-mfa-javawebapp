package com.microsoft.demo.azuremfaspringboot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private @Autowired AutowireCapableBeanFactory beanFactory;

	@Value("${nonauthenticatedpaths}")
	private String nonauthenticatedpaths;

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
    
	
    @Bean
    public FilterRegistrationBean adalFilter(){
    	FilterRegistrationBean registration = new FilterRegistrationBean();
    	AdalFilter adalFilter = new AdalFilter();
    	beanFactory.autowireBean(adalFilter);
    	registration.setFilter(adalFilter);
    	String[] items = nonauthenticatedpaths.split(",");
    	for(String path : Arrays.asList(items)){
        	registration.addUrlPatterns(path);
    	}
    	registration.setOrder(1);
    	return registration;
    }

    
}
