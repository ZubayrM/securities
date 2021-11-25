package com.zubayr.egar.securities.filter.Config;

import com.zubayr.egar.securities.filter.SecurityControllerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConfigFilter {

    @Bean
    FilterRegistrationBean<SecurityControllerFilter> filterRegistrationBean(){
        FilterRegistrationBean<SecurityControllerFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new SecurityControllerFilter());
        filterRegistrationBean.addUrlPatterns("/api/add");
        return filterRegistrationBean;
    }

}
