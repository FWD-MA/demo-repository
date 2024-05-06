package com.test.FWD.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class JwtUtils {

    private static String signKey = "FWDTEAM";

    //过期时间六个小时
    private static Long expire = 21600000L;

    //生成jwt令牌
    public static String generateJwt(Map<String, Object> claims){

        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
    }

    //解析jwt令牌
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }



}
