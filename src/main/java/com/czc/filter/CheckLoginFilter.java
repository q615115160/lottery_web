package com.czc.filter;

import com.czc.bean.User;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName:CheckLoginFilter
 * Description:
 */
//配合@ServletComponentScan使用 注解在app启动类之上
@WebFilter(urlPatterns = {"/bbs/publish","/comment/add","/chart/*","/order/*","/user/myUI"})
public class CheckLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //check user
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse resp= (HttpServletResponse) response;

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            chain.doFilter(request, response);
        }else{
            resp.sendRedirect("/hehe/user/loginUI");
        }
    }

    @Override
    public void destroy() {

    }
}
