package com._12306.back.filter;

import com._12306.back.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;
@Slf4j
@Component
public class AuthenticationFilter implements Filter {


    private static final AntPathMatcher PATH_MATCHER =new AntPathMatcher() ;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        String[] urls=new String[]{
                "/user/login",
                "/user/logout",
                "/swagger-ui/"
        };
        boolean check = check(urls, requestURI);
        if (check) {
            filterChain.doFilter(request, response);
            return;
        }else {
            String token = request.getHeader("Authorization");
            if(JwtUtils.isTokenValid(token)){
                filterChain.doFilter(request,response);
                return;
            }else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
            }
            return;
        }

    }
    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            boolean match=PATH_MATCHER.match(url,requestURI);
            if(match)return true;
        }
        return false;
    }
}
