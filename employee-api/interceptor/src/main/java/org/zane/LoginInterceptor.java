package org.zane;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    // objectMapper 用來將class 轉為string
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // get token from request header
        String token = request.getHeader("Token");

        // authenticate the token
        if (token == null) {

//            throw new BaseException("token is null");

            String jsonResult = objectMapper.writeValueAsString(
                    Result.error("TokenNotExisted")
            );

            // response the error message
            response.getWriter().write(jsonResult);

            return false;

        } else {

            try {

                // parse the token
                // parse的結果會是一開始generate JWT時放入的claims
                // for example: hashMap.put("username","zane");
                // claims:
                // {exp=1698044261, username=zane}
                Claims claims = JwtUtils.parseJwt(token);

                // store the token to threadLocal
                ThreadLocalUtils.setCurrentValue(claims.get("username").toString());

                // return ture to continue the request
                return true;

            } catch (Exception e) {
                //                throw new BaseException("token is invalid");

                e.printStackTrace();

                String jsonResult = objectMapper.writeValueAsString(
                        Result.error("InvalidToken")
                );

                // response the error message
                response.getWriter().write(jsonResult);

                return false;


            }


        }


    }

    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
