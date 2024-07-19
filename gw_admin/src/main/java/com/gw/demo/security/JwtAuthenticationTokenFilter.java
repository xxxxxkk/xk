package com.gw.demo.security;

import com.alibaba.fastjson.JSON;
import com.gw.config.JWTConfig;
import com.gw.demo.entity.UserEntity;
import com.gw.util.JWTUtils;
import com.gw.util.Result;
import com.gw.util.ResultConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token) || !token.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = token.substring(7); // Remove "Bearer " prefix
        String JSONUser;
        try {
            Claims claims = Jwts.parser().setSigningKey(JWTConfig.secret.getBytes()).parseClaimsJws(jwt).getBody();
            JSONUser = claims.getSubject();
        } catch (ExpiredJwtException e) {
            log.error("Token expired or invalid", e);
            sendErrorResponse(response, Result.fail(ResultConstant.JWT_ERROR.getResCode(),ResultConstant.JWT_ERROR.getResDesc()));
            return;
        }

        UserEntity userInfo = JSON.parseObject(JSONUser, UserEntity.class);
        Long userId = userInfo.getAdminId();
        String redisKey = "token:" + userId;
        String userToken = (String) redisTemplate.opsForValue().get(redisKey);
        UserEntity user = jwtUtils.parseToken(userToken, UserEntity.class);
        if (Objects.isNull(user)) {
            sendErrorResponse(response, Result.success(ResultConstant.JWT_ERROR));
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }

    private void sendErrorResponse(HttpServletResponse response, Result error) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(JSON.toJSONString(error));
    }
}
