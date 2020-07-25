package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Arrays;
import java.util.Map;

/**
 * @author 熟尔
 * @createdate 2019/9/12 0012-16:25
 */

/*以前的Springmvc都不需要配置，直接使用*/

@Controller
public class HelloController {

    /*下面的注解responseBody就是为了能够返回到页面*/
    @ResponseBody

    @RequestMapping("/hello")
    public  String  syaHello(){

        return  "HelloWorld";
    }


    @RequestMapping("/hello1")
    /*这里的/hello1就是下面的方法的简称， 用来进行映射的
    使用来进行网页的网址的输入， 来使用这个方法的
    我们直接用网址来访问这个方法chengong， 当然肯定不是输入cehngong方法名，
    而是输入映射hello1来进行方法的访问
    */
    public  String  chengong(Map<String, Object> map){
        /*这里返回到AAA页面， 而这个页面先去templates里面去找页面jsp页面*/

        map.put("hello","<h1>你好！！！</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return  "indes1";
    }
}
