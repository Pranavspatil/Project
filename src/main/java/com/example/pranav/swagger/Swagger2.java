package com.example.pranav.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class Swagger2 implements WebMvcConfigurer{
	
	private final String serviceTitle = "EMPLOYEE-MANAGEMENT-SYSTEM";
	private final String serviceDescription ="This document contain APIs of EMPLOYEE-SERVICE";
	private final String version = "1.0.0";
	
	@Bean
	public Docket configApi() {
		return new Docket(DocumentationType.SWAGGER_2).select() 
				.apis(RequestHandlerSelectors.basePackage("com.example.pranav.Controller")).build().apiInfo(apiEndPointInfo());
//		return new Docket(DocumentationType.SWAGGER_2).groupName("example").apiInfo(apiInfo()).select().paths(Regex("/emp.*")).build();
	}
	
		private ApiInfo apiEndPointInfo() {
		return new ApiInfoBuilder().title(serviceTitle).description(serviceDescription).version(version).build();
	}
		@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {

	        registry
	                .addResourceHandler("swagger-ui.html")
	                .addResourceLocations("classpath:/META-INF/resources/");

	        registry
	                .addResourceHandler("/webjars/**")
	                .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }

	

}
