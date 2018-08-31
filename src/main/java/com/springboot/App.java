package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.filter.RequestContextFilter;

//exclude array of classes from auto configuration
//@SpringBootApplication(exclude = {H2ConsoleAutoConfiguration.class, DispatcherServletAutoConfiguration.class})
//@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	 SpringApplication.run(App.class, args);
    }

	@Bean
	public FilterRegistrationBean deRegisterHiddenHttpMethodFilter (HiddenHttpMethodFilter  filter) {
	    FilterRegistrationBean registration = new FilterRegistrationBean(filter);
	    registration.setEnabled(false);
	    return registration;
	}
	
	@Bean
	public FilterRegistrationBean deRegisterHttpPutFormContentFilter (HttpPutFormContentFilter  filter) {
	    FilterRegistrationBean registration = new FilterRegistrationBean(filter);
	    registration.setEnabled(false);
	    return registration;
	}
	
	@Bean
	public FilterRegistrationBean deRegisterRequestContextFilter (RequestContextFilter  filter) {
	    FilterRegistrationBean registration = new FilterRegistrationBean(filter);
	    registration.setEnabled(false);
	    return registration;
	}
}