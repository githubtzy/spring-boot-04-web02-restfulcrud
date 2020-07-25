package com.atguigu.springboot.component;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 熟尔
 * @createdate 2019/9/23 0023-21:20
 *
 *
 * 拦截器
 * 就是登录检查， 没有登录账号的用户，就不能够访问内部的消息，我们需要使用拦截器进行设置
 *
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
@Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null){
            //未登录
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return  false;
        }
        else{
//            已经登录，请放行。
            return  true;
        }
    }}








