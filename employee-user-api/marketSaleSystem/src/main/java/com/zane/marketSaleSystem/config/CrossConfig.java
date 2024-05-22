package com.zane.marketSaleSystem.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
您的配置確實已經定義了全局的crossConfig，所以您理論上不應該還需要在每個控制器上加上 @CrossOrigin。但如果您仍然遇到問題，可能是以下原因之一：

@EnableWebMvc 注解: 使用 @EnableWebMvc 會導致Spring Boot的自動配置失效。這意味著，您需要自己配置所有的MVC特性。如果您沒有特殊的原因使用它，建議您移除 @EnableWebMvc 注解，讓Spring Boot進行默認的自動配置。

@Configuration:
它表示該類是一個配置類，用於定義Spring的bean配置。
它允許您使用Java類（而不是XML文件）來配置Spring的beans。
配置類通常會與@Bean注解一起使用，@Bean用於定義並實例化Spring管理的bean。

@EnableWebMvc:
它是Spring MVC的特定注解，用於啟用Spring MVC的默認配置。
使用這個注解意味著您想要完全控制Spring MVC的配置，並覆蓋Spring Boot的默認MVC配置。
通常，當您想要提供自定義的MVC配置（例如視圖解析器、消息轉換器等）時，您會使用這個注解。

當使用Spring Boot時，通常不推薦使用@EnableWebMvc，除非您有特定的原因需要完全覆蓋Spring Boot提供的默認MVC配置。如果只是想要擴展或修改部分MVC配置，則不需要@EnableWebMvc。
 */
@Configuration
//@EnableWebMvc
public class CrossConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // 具体的请求路径
                .allowedOrigins("http://localhost:5173") // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的 HTTP 方法
                .allowedHeaders("Content-Type","Token") // 允许request提供的请求头
                .exposedHeaders("Token", "Set-Cookie"); // 暴露的請求頭，讓前端可以取得
    }
}

