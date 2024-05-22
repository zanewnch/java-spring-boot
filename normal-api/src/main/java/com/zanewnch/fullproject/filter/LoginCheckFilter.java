package com.zanewnch.fullproject.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zanewnch.fullproject.utils.JsonUtil;
import com.zanewnch.fullproject.utils.Jwtutil;
import com.zanewnch.fullproject.utils.Result;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Order(1)
@Slf4j
//@ServletComponentScan
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //        get url from request
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURL().toString();

        //        judge whether the url include login string
        if (url.contains("login")) {

            log.info("login...");
            //            directly continue to the controller
            filterChain.doFilter(servletRequest, servletResponse);

            /*
            In order to prevent run the code below, for example, the logic manipulate after controller, so it is necessary to add return here when the specific condition statement is satisfied.
             */
            return;
        }else{
//            get token from request header
            String jwt =  req.getHeader("token");

            if(StringUtils.hasLength(jwt)){

                /*
                補充一下：
                如果try is success, 就會繼續執行下面的code snippet;但如果catch error,就不會繼續執行下面的code snippet, 而是直接print out the exception.
                 */
                try {
                    //                parse the jwt token
                    Jwtutil.parseJwt(jwt);

                }catch (Exception e) {
                    e.printStackTrace();

                    log.info("the token is error or empty");

                    Result error =  Result.error("Not yet Login in, Please Login in first.");

                    /*
                convert the error to the json data type
                 */
                    String json = JsonUtil.toJson(error);

                    res.getWriter().write(json);
                    return;
                }

                log.info("The token is available,continue to controller");

                filterChain.doFilter(req,res);

                

                

            }else{

                /*
                如果Token 錯誤，可以直接在filter 
                 */
                System.out.println("The token is error or empty");
                Result error =  Result.error("Not yet Login in, Please Login in first.");
                /*
                convert the error to the json data type
                 */
                String json = JsonUtil.toJson(error);


                //                directly response the error message to the front end
                res.getWriter().write(json);
                return;
            }

        }
    }
}
