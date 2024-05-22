package org.zane.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sky.jwt")
public class JwtProperties {
    /*
    我還分不太出來configurationProperties 跟constant 的差別
    但總之properties 也是用來存放常數的
    然後他的用法是：
    1. 先在application.yml 裡面寫好
    2. 然後 在這裡寫一個對應的class
    3. 然後在這個class 上面加上 @Component 跟 @ConfigurationProperties(prefix = "sky.jwt")    sky.jwt 就是你在application.yml 裡面寫的那個
    4. 然後要使用這個properties 的時候，要先@autowired this properties
     */

    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;

}
