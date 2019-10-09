package com.enlie.blog.config;


import com.enlie.blog.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyBackMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/back/").setViewName("backstage/login");
        registry.addViewController("/back").setViewName("backstage/login");
        registry.addViewController("/back/index").setViewName("backstage/index");
        registry.addViewController("/back/login").setViewName("backstage/login");
        registry.addViewController("/login").setViewName("backstage/login");
        registry.addViewController("/back/test").setViewName("backstage/test");
        registry.addViewController("/back/flink").setViewName("backstage/flink");
        registry.addViewController("/back/add_flink").setViewName("backstage/add-flink");
        registry.addViewController("/back/404").setViewName("backstage/404");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("/i18n/login");
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setCacheSeconds(100);
//        return messageSource;
//    }

}
