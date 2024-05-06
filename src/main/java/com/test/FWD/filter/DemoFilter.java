package com.test.FWD.filter;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.test.FWD.utils.JwtUtils;
import org.apache.coyote.Response;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class DemoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        //获取请求url
        String url = req.getRequestURL().toString();
        
        //判断
        if(url.contains("login")||url.contains("register")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //获取令牌
        String jwt = req.getHeader("token");

        if(StringUtils.isBlank(jwt)){
            String s = "Not Login";
            String json = JSONObject.toJSONString(s);
            resp.getWriter().write(json);
            return;
        }

        //校验令牌
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            String s = "Not Login";
            String json = JSONObject.toJSONString(s);
            resp.getWriter().write(json);
            return;
        }
        //放行
        filterChain.doFilter(servletRequest,servletResponse);

    }


}
