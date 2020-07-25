package com.atguigu.springboot.config;

import com.atguigu.springboot.component.LoginHandlerInterceptor;
import com.atguigu.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;


/**
 * @author 熟尔
 * @createdate 2019/9/17 0017-10:43
 *
 *  这个是SpringMVC和structs
 *  这是MVC的配置文件，里面是配置的页面的跳转  COntroller和view
 */

//
//@Configuration
@Configuration
public class MyMvcConfig  implements WebMvcConfigurer {

    public  void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/guigu").setViewName("indes1");
    }


            //下面是配置拦截器的
    @Bean
    public   WebMvcConfigurer wbMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer(){
            public  void addViewControllers(ViewControllerRegistry registry){


                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");

            }

            @Override
            public void   addInterceptors(InterceptorRegistry registry){
            //excludePathPatterns 表示除此之外的都需要拦截，
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/index.html","/user/login","/asserts/**");
            }
        };

        return  configurer;
    }


    @Bean
        public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
