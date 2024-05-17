package com.ssafy.tripds.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@OpenAPIDefinition(
		info = @Info(
				title = "trip ds api 명세서",
				description = "<h3>trip ds API Reference for Developers</h3>Swagger를 이용한 VUE API",
				version = "v1",
				contact = @Contact(
						name = "ji jong kwon",
						email = "help3451@naver.com",
						url = "https://naver.com"
				)
		),
		security = @SecurityRequirement(name = "bearerAuth")
)
@Configuration
@SecurityScheme(
		name = "bearerAuth",
		type = SecuritySchemeType.APIKEY,
		in = SecuritySchemeIn.HEADER,
		paramName = "Authorization"
)
public class SwaggerConfiguration {
	@Bean
	public GroupedOpenApi allApi() {
		return GroupedOpenApi.builder().group("ssafy-all").pathsToMatch("/**").build();
	}
	@Bean
	public GroupedOpenApi boardApi() {
		return GroupedOpenApi.builder().group("ssafy-board").pathsToMatch("/board/**").build();
	}
	@Bean
	public GroupedOpenApi userApi() {
		return GroupedOpenApi.builder().group("ssafy-user").pathsToMatch("/api/user/**").build();
	}
	@Bean
	public GroupedOpenApi mapApi() {
		return GroupedOpenApi.builder().group("ssafy-map").pathsToMatch("/map/**").build();
	}
}