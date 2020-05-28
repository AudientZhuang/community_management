package com.saltedfish.community_management.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Audient
 * @date 2020/5/28
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Value("${file.upload-folder}")
    private String uploadFolder;

    /**
     * 配置虚拟路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+uploadFolder);
    }

    /**
     * 跨域处理
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST","PUT","GET","DELETE","OPTIONS","HEAD")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

}
