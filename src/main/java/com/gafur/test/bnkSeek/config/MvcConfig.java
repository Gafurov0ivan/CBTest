package com.gafur.test.bnkSeek.config;

import com.gafur.test.bnkSeek.service.BnkSeekService;
import com.gafur.test.bnkSeek.service.BnkSeekServiceImpl;
import com.gafur.test.bnkSeek.service.CataloguesService;
import com.gafur.test.bnkSeek.service.CataloguesServiceImpl;
import com.gafur.test.bnkSeek.util.BnkSeekUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Конфигурация MCV
 *
 * @author igafurov
 * @since 30.11.2017
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.gafur.test.bnkSeek.controller"})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public BnkSeekService getBnkSeekService() {
        return new BnkSeekServiceImpl();
    }

    @Bean
    public CataloguesService getPznService() {
        return new CataloguesServiceImpl();
    }

    @Bean
    public BnkSeekUtil initializeBnkSeek() {
        return new BnkSeekUtil();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }
}
