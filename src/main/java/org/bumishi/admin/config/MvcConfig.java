package org.bumishi.admin.config;

import org.bumishi.admin.interfaces.intercept.NavMenuActiveInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author qiang.xie
 * @date 2016/11/16
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Value("${admin.cloth.upload.path}")
    private String imgUploadPath;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/to-login").setViewName("login");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/403").setViewName("error/403");
        registry.addViewController("/401").setViewName("error/401");
        registry.addViewController("/404").setViewName("error/404");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new NavMenuActiveInterceptor());
    }
    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload_img/**").
                addResourceLocations("file:"+ imgUploadPath);
    }
}
