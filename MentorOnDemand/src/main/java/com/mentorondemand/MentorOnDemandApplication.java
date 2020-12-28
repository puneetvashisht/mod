package com.mentorondemand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MentorOnDemandApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorOnDemandApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiDetails()).select().paths(PathSelectors.ant("/api/**"))
				.apis(RequestHandlerSelectors.basePackage("com.mentorondemand")).build();
	}

	private ApiInfo apiDetails() {
		return new ApiInfoBuilder().title("MENTOR ON DEMAND")
				.description("This is App for mentor on demand").build();
	}

}
