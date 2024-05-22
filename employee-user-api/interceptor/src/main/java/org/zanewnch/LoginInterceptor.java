package org.zanewnch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


/**
 * The completed edition for login authentication and authorization
 */
// 寫完interceptor class, 要到spring boot module/config 寫相對應的 config file
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    // objectMapper 用來將class 轉為string
    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Detect whether the request has token for login.
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return boolean
     * @throws IOException IOException
     */
    private boolean authentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // check if the request is for login
        // if is login behavior, directly return true
        String requestUrl = request.getRequestURL().toString();


        if (requestUrl.contains("login")) {
            log.info("continue to login process...");
            return true;
        }


        String jwtToken = request.getHeader("token");

        if (StringUtils.hasLength(jwtToken)) {
            try {
                JwtUtils.parseJwt(jwtToken);

                return true;
            } catch (Exception e) {
                e.printStackTrace();

                String jsonResult = objectMapper.writeValueAsString(Result.error("InvalidToken"));
                response.getWriter().write(jsonResult);
                return false;
            }
        } else {


            String jsonResult = objectMapper.writeValueAsString(Result.error("No Token, Please Login"));

            response.getWriter().write(objectMapper.writeValueAsString(jsonResult));

            return false;
        }


    }

    /**
     * preHandle 的執行順序為controller之前，所以如果preHandle return true, 才會放行去run controller, 如果 preHandle return false, 則跑完preHandle 就會直接break the app.
     */
    // todo : if interceptor block the request, the frontend should turn to login page
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // authentication
        if (authentication(request, response)) {
            return true;
        } else {
            return false;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
