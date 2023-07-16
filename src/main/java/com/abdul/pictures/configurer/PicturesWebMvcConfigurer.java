package com.abdul.pictures.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class PicturesWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        var pageableHandler = new PageableHandlerMethodArgumentResolver();
        pageableHandler.setFallbackPageable(Pageable.ofSize(12));
        resolvers.add(pageableHandler);
    }
}
