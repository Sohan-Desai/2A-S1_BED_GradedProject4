package com.practice.project4.util;

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
				.groupName("Library-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.practice.project4"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Library_Api")
				.description("Library API reference for developers")
				.termsOfServiceUrl("http://fakeLibrary.com")
				.contact(new springfox.documentation.service
				.Contact("Library API", "http://fakeLibrary.com", "john123@gmail.com"))
				.license("Library License")
				.licenseUrl("http://fakeLibrary.com")
				.version("2.0").build();
	}

}
