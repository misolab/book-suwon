package com.misolab.booksuwon.web.config;

import static com.misolab.booksuwon.common.util.StringUtils.isNotEmpty;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.misolab.booksuwon.web.util.LoginUserArgumentResolver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@PropertySources({
        @PropertySource("classpath:/resource.properties"),
        @PropertySource(value = "classpath:/resource-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${resources.location:}")
    private String resourcesLocation;

    @Value("${resources.uri_path:}")
    private String resourcesUriPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (isNotEmpty(resourcesLocation) && isNotEmpty(resourcesUriPath)) {
            registry.addResourceHandler(resourcesUriPath + "/**")
                    .addResourceLocations("file://" + resourcesLocation);
        }
    }

    final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserArgumentResolver);
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }
    
}
