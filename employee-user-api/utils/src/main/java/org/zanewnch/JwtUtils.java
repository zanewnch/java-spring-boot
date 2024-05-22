package org.zanewnch;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/*
map: {"key",value}
 */

public class JwtUtils {

    /**
     * Map<String,Object> is {"tokenName","tokenValue"}
     * for example: {"username","admin"}
     * @param claims
     * @return
     */
    public static String generateJwt(Map<String, Object> claims){

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"zanewnch")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 60*1000*60))
                .compact();
    }

    /**
     * Claims 長這樣： {exp=1696069373, username=admin}   (tokenName=tokenValue)
     * @param jwt
     * @return
     */
    public static Claims parseJwt(String jwt){

        return Jwts.parser()
                .setSigningKey("zanewnch")
                .parseClaimsJws(jwt)
                .getBody();
    }
}
