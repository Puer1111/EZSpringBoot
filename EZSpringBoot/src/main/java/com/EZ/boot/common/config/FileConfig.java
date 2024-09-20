package com.EZ.boot.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// configuration --> 설정 파일로 설정
public class FileConfig implements WebMvcConfigurer{
	private String webPath ="/images/**";  					//images/notice/**
	private String realPath= "file:C:/uploadFile/notice"; //file:C:/uploadFile/notice

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(webPath)
			.addResourceLocations(realPath);
	}
	
	
	
}
