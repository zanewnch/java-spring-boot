package org.zane.server.config;

import cn.hutool.core.util.RandomUtil;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.zane.JacksonObjectMapper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    /*
    CORS 跨域請求
     */
    @Override
    protected void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        registry.addMapping("/api/**") // 具体的请求路径
                .allowedOrigins("*") // 允许的源
//                .allowedOrigins("http://localhost:5173") // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的 HTTP 方法
                .allowedHeaders("Content-Type", "Token") // 允许request提供的请求头
                .exposedHeaders("Token", "Set-Cookie"); // 暴露的請求頭，讓前端可以取得
    }

    /*
    interceptors 攔截器
     */
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//
//       registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/api/**") // 拦截的请求路径
//                .excludePathPatterns("/api/admin/employees/signIn"); // 不拦截的请求路径
//
//
//    }

    /*
    knife4j configuration 頁面是有出來 但詳細內容我都不知道如何修改  所以還是先不用

    https://gitee.com/xiaoym/swagger-bootstrap-ui-demo/blob/master/knife4j-spring-boot3-demo/src/main/java/com/github/xiaoymin/boot3/config/SwaggerConfig.java
     */

    /**
     * 根据@Tag 上的排序，写入x-order
     *
     * @return the global open api customizer
     */
    @Bean
    public GlobalOpenApiCustomizer orderGlobalOpenApiCustomizer() {
        return openApi -> {
            if (openApi.getTags() != null) {
                openApi.getTags().forEach(tag -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("x-order", RandomUtil.randomInt(0, 100));
                    tag.setExtensions(map);
                });
            }
            if (openApi.getPaths() != null) {
                openApi.addExtension("x-test123", "333");
                openApi.getPaths().addExtension("x-abb", RandomUtil.randomInt(1, 100));
            }

        };
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("XXX用户系统API")
                        .version("1.0")

                        .description("Knife4j集成springdoc-openapi示例")
                        .termsOfService("http://doc.xiaominfo.com")
                        .license(new License().name("Apache 2.0")
                                .url("http://doc.xiaominfo.com")));
    }

    /*
    配置訊息轉化器：

    主要就是將response data的格式做調整
    目前這個案例是將sql Date格式做修改
    sql format: 2022-02-15 15:51:20
    original response format: "updateTime": [
                    2023,
                    10,
                    22,
                    16,
                    12,
                    20
                ]

     The goal format after message converter:
     2022-02-15 15:51



     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        // create the message converter object
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // 需要為message converter 設置一個 objectMapper
        // objectMapper的用途是用於序列化(將java object turn into json string)
        converter.setObjectMapper(new JacksonObjectMapper());

        // 將自製message converter加入到 converters容器當中
        // 0是索引，代表第一個，優先使用
        converters.add(0, converter);
    }


}
