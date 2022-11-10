package com.greatlearning.employee_management.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket libraryApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.groupName("Employee_Management-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.greatlearning.employee_management"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Employee_Management-API")
				.description("Employee Management API reference for developers")
				.termsOfServiceUrl("http://employeeManagement.com")
				.contact(new springfox.documentation.service
				.Contact("Employee Management API", "http://employeeManagement.com", "john123@gmail.com"))
				.license("In-situ License")
				.licenseUrl("http://employeeManagement.com")
				.version("2.0").build();
	}

}
