package com.test.FWD.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.test.FWD.dtos.User;
import com.test.FWD.service.LoginService;
import com.test.FWD.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//登录注册
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录的接口
    @PostMapping("/login")
    public String login(@RequestBody User user){
        User u = loginService.getByName(user);
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        if(!password.equals(u.getPassword())){
            return "密码错误，登录失败";
        }
        //登录成功下发jwt令牌
        if(u!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",u.getId());
            claims.put("name",u.getUsername());
            return JwtUtils.generateJwt(claims);
        }

        //登陆失败
        return "登录失败";

    }

    //注册的接口
    @PostMapping("/register")
    public void register(@RequestBody User user){
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(password);
        loginService.saveUser(user);
    }

}
