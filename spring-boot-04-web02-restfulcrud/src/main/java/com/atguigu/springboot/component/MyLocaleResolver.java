package com.atguigu.springboot.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author 熟尔
 * @createdate 2019/9/18 0018-11:13
 */

// 区域解析器，主要是用来设置中国英文切换的
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");//连接到页面请求，页面点击连接。
        Locale locale = Locale.getDefault() ;//默认的根据浏览器的环境设置语言环境

        //这时候设置请求头，来代码设置请求头，实现点击按钮实现语言环境的转换。
        if (!StringUtils.isEmpty(l)){

            /*以_来把字符串进行分割
            * th:href="@{/index.html(l='zh_CN')}">中文</a>
            * th:href="@{/index.html(l='en_US')
            * */
            String[] split = l.split("_");//把'zh_CN'分成两个部分
            locale = new Locale(split[0], split[1]);


        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
