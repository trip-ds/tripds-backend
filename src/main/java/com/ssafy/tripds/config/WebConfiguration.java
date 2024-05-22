package com.ssafy.tripds.config;

import com.ssafy.tripds.interceptor.JWTInterceptor;
import com.ssafy.tripds.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {

	private final JWTUtil jwtUtil;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(),
						HttpMethod.DELETE.name(), HttpMethod.HEAD.name(), HttpMethod.OPTIONS.name(),
						HttpMethod.PATCH.name())
			.maxAge(1800); // Pre-flight Caching
	}

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/assets/img/");
		registry.addResourceHandler("/*.html**").addResourceLocations("classpath:/static/");
    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new JWTInterceptor(jwtUtil))
				.addPathPatterns("/api/**")
				.excludePathPatterns("/api/user/login", "/api/user/signup")
				.excludePathPatterns("/api/cctv/**", "/api/light/**")
				.excludePathPatterns("/api/estate/**")
				.addPathPatterns("/api/estate/planner/**", "/api/estate/interest/**")
				.excludePathPatterns(String.valueOf(HttpMethod.OPTIONS), "/**");
	}
}
