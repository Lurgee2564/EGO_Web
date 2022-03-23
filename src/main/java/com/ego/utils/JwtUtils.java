package com.ego.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Data
@ConfigurationProperties("jwt.config")
@Component
public class JwtUtils {
    private String key;
    private Long failureTime;

    public String createJwt(String id, String subject, Map<String, Object> map){
        Long now = System.currentTimeMillis();
        Long exp = now+failureTime;

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,key);

        for (Map.Entry<String,Object>entry:map.entrySet()){
            jwtBuilder.claim(entry.getKey(),entry.getValue());
        }
        jwtBuilder.setExpiration(new Date(exp));

        String token = jwtBuilder.compact();

        return token;

    }

    public Claims parseJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return  claims;
    }


}
