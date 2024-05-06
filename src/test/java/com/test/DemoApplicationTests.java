package com.test;

import com.test.FWD.dtos.User;
import com.test.FWD.mapper.LoginMapper;
import com.test.FWD.service.LoginService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {


    @Test
    public void test(){
        String password = "123456";
        String s = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(s);
    }

}
