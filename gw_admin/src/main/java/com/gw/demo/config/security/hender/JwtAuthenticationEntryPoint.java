package com.gw.demo.config.security.hender;

import com.gw.constans.ResCodeContants;
import com.gw.util.Result;
import com.gw.util.ResultConstant;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // 当未经身份验证的用户尝试访问受保护的资源时，发送401 Unauthorized响应
        response.sendError(Integer.parseInt(ResultConstant.JWT_ERROR.getResCode()),ResultConstant.JWT_ERROR.getResDesc());
    }
}
