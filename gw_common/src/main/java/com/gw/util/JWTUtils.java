package com.gw.util;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class JWTUtils {

    @Value("${jwt.expireTime}")
    private Long expireTime;

    @Value("${jwt.secret}")
    private String secret;

    public String createJwt(Object data) {
        long currentTimeMillis = System.currentTimeMillis();
        long expireTimeMillis = currentTimeMillis + (expireTime * 1000 * 60);

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(JSON.toJSONString(data))
                .setIssuer("system")
                .setIssuedAt(new Date(currentTimeMillis))
                .signWith(encodeSecret(), SignatureAlgorithm.HS256);
        return jwtBuilder.compact();
    }

    private SecretKey encodeSecret() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Boolean validJwt(String jwt) {
        try {
            jwt = jwt.replace("Bearer ", "");
            Jwts.parser().setSigningKey(encodeSecret()).parseClaimsJws(jwt);
        } catch (Exception e) {
            log.error("JWT validation failed: {}", e.getMessage());
            return false;
        }
        return true;
    }

    public <T> T parseJwt(String jwt, Class<T> tClass) {
        jwt = jwt.replace("Bearer ", "");
        Claims body = Jwts.parser()
                .setSigningKey(encodeSecret())
                .parseClaimsJws(jwt)
                .getBody();
        return JSON.parseObject(body.getSubject(), tClass);
    }
    public <T> T parseToken(String token, Class<T> tClass) {
        try {
            if (token == null || token.trim().isEmpty()) {
                throw new IllegalArgumentException("token无效");
            }
            Claims body = Jwts.parser()
                    .setSigningKey(encodeSecret())
                    .parseClaimsJws(token)
                    .getBody();
            return JSON.parseObject(body.getSubject(), tClass);
        } catch (Exception e) {
            throw new IllegalArgumentException("token无效");
        }
    }

}
