package com.zanewnch.fullproject.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/*
zanewnch 是固定的   當user第一次訪問server的時候就會根據zanewnch 去加密產生 jwt 給client
然後之後client request server 的時候要攜帶jwt, server再透過zanewnch 去decode
 */

public class Jwtutil {

    /**
     * Generate JWT token with receiving Map.
     * @return String
     */
    public static String generateJwt(Map<String, Object> claims){

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"zanewnch")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+ 60*60*1000))
                .compact();
    }

    /**
     * Parse JWT token to json.
     * @return String
     */

    public static Claims parseJwt(String jwt){

        return Jwts.parser()
                .setSigningKey("zanewnch")
                .parseClaimsJws(jwt)
                .getBody();

    }
}
