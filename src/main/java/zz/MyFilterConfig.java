package zz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class MyFilterConfig {
    @Autowired
    private EventNotify EventNotify;

    @Bean
    public FilterRegistrationBean<Filter> addFilter(){
        System.out.println("필터 등록됨");
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilter(EventNotify));
        bean.addUrlPatterns("/sse");
        return bean;
    }


    @Bean
    public FilterRegistrationBean<Filter> addFilter2(){
        System.out.println("필터2 등록됨");
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilter2(EventNotify));
        bean.addUrlPatterns("/add");
        return bean;
    }
}
