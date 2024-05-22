package com.zanewnch.fullproject.interceptor;

import com.zanewnch.fullproject.utils.JsonUtil;
import com.zanewnch.fullproject.utils.Jwtutil;
import com.zanewnch.fullproject.utils.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
Interceptor 跟 filter 最大的差別：
1. 原先的parameter 就已經是httpServletreq and res, 不需要再轉換
2. 要放行到controller, 直接return true 就好，不需要再invoke doFilter method
3. 要拒絕放行到controller, 在response error message之後，不能再只寫return, 而是要return false
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    /*
    This method run before controller and return the boolean, if true it would continue to controller, otherwise if return false it would stop
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("beforeController...");
        System.out.println("beforeController...");

        /*
        1. turn reqeust and response to httpServletRequest and httpServletResponse, but because we are using interceptor now, the req and res pass to this method are already httpServletRequest and httpServletResponse
         */

        //        HttpServletRequest req = (HttpServletRequest) request;
    //        HttpServletResponse res = (HttpServletResponse) response;

        /*
        2. determine whether the user is logged in, if true, continue to controller, otherwise return stop the process
         */
//        get request url
        String url = request.getRequestURL().toString();
        log.info("The request url is: {}", url);

//        judge whether the url contains login,if true, pass to interceptor
        if (url.contains("login")) {
            log.info("continue to login...");
            return true;
        } else {
//            get the token from request header
            String jwt = request.getHeader("token");

            if(StringUtils.hasLength(jwt)){

                try {

                    Jwtutil.parseJwt(jwt);

                }catch (Exception e){
                    e.printStackTrace();

                    log.info("Token Error...");
                    String error = JsonUtil.toJson(
                            Result.error("Token Error...")
                    );
                    response.getWriter().write(error);
                    return false;
                }

                log.info("Token Success...");
                return true;

            }else {
                log.info("Token Error...");
                String error = JsonUtil.toJson(
                        Result.error("Token Error...")
                );
                response.getWriter().write(error);
                return false;

            }


        }




        /*
        The content of below is set by IDE default
         */
        //        return HandlerInterceptor.super.preHandle(request, response, handler);

    }

    /*
    This method run after controller
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("afterController...");
        System.out.println("afterController...");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /*
    This method run after response
     */
    /*
    The default definition of this method is run after rendering the view, but in now day backend does not control rendering of view, so it can be parsed as after response the data.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterResponse...");
        System.out.println("afterResponse...");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
