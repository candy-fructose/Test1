/**
 * @FileName:
 * @Date:2020/5/28 17:34
 * @Description:
 */
package com.javasm.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;

//        Object loginUser=request.getSession().getAttribute("loginUser");
//        if(loginUser!=null){
//            System.out.println("拦截器生效，已登录");
//            return true;
//        }else {
//            request.getRequestDispatcher("/login").forward(request,response);
//            System.out.println("拦截器生效，未登录");
//            return false;
//        }
    }
}
