package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;
//import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author 熟尔
 * @createdate 2019/9/23 0023-19:07
 */
@Controller
public class LoginController {
//    @RequestMapping("/user/login")
//    这个作者喜欢去先写Controller文件，然后去写其他的根据控制的流程
    @PostMapping("/user/login")
    public  String login(
            @RequestParam("username")  String username,
            @RequestParam("pwd") String password,
            Map<String,Object> map,

            HttpSession session

    ){
        if (!StringUtils.isEmpty(username)  && "1234567".equals(password)){

//            为了防止表单重复提交，可以重新定向到主页
            session.setAttribute("loginUser" , username);
            return  "redirect:/main.html" ;

//            return "dashboard";
        }else {


//            给出提示信息，使用map来
            map.put("msg", "用户名错误！！！");//其实这个时候的map就是相当于一个重命名啊，
//            很是巧妙啊，这里map的理解。
            return  "login"; //返回到页面需要加上双引号
        }
    }
}
