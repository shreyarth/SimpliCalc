package com.springbootphase3end.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.paths(postPath())
				.build();
	}

	private Predicate<String> postPath() {
		// TODO Auto-generated method stub
		return or(regex("/api/.*"), regex("/api/posts/.*"));
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder()
				.title("Todo List")
				.description("Welcome to the todo lists swagger api")
				.termsOfServiceUrl("http://nothinghere.com")
				.licenseUrl("http://nothinghere.com")
				.version("1.0")
				.build();
	}
}
