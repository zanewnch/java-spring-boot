package com.zane.marketSaleSystem;

import com.zane.marketSaleSystem.controller.SupermarketSaleController;
import com.zane.marketSaleSystem.mapper.SupermarketSaleMapper;
import com.zane.marketSaleSystem.service.SupermarketSaleService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.*;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 在applicationTest當中，controller,service,mapper 的method都可以直接執行，不需要接收request,
 * parameter data 直接 new entity 然後傳入即可
 */
@SpringBootTest
class MarketSaleSystemApplicationTests {

    // mockito framework for testing

    private final SupermarketSaleController supermarketSaleController;
    private final SupermarketSaleService supermarketSaleService;
    private final SupermarketSaleMapper supermarketSaleMapper;

    private final RedisTemplate redisTemplate;

    @Autowired
    public MarketSaleSystemApplicationTests(SupermarketSaleController supermarketSaleController, SupermarketSaleService supermarketSaleService, SupermarketSaleMapper supermarketSaleMapper,
                                            RedisTemplate redisTemplate) {
        this.supermarketSaleController = supermarketSaleController;
        this.supermarketSaleService = supermarketSaleService;
        this.supermarketSaleMapper = supermarketSaleMapper;
        this.redisTemplate = redisTemplate;
    }

    @Test
    void controllerTest() {
        supermarketSaleController.get();
    }

    /**
     * redisTemplate一定要先在config file當中設定好.
     * redis data是以key-value pair的形式存儲的
     */
    @Test
    void redisTemplateTest() {

        ValueOperations valueOperations = redisTemplate.opsForValue();
        HashOperations hashOperations = redisTemplate.opsForHash();
        ListOperations listOperations = redisTemplate.opsForList();
        SetOperations setOperations = redisTemplate.opsForSet();
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

        valueOperations.set("test", "testValue");
        String testValue = (String) valueOperations.get("test");

        valueOperations.set("testWithTime", "testValue", 10, TimeUnit.MINUTES);
    }

    @Test
    void getAllRedisValue() {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        Map<String, String> allValues = hashOperations.entries("*");
        System.out.println(allValues);

        Set<String> allKeys = redisTemplate.keys("*");
        System.out.println(redisTemplate.opsForValue().multiGet(allKeys));

    }

    /*
    主動send request
     */
    @Test
    void httpClientRequestGet() {

        // Create httpClient object
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // create request object
            HttpGet httpGet = new HttpGet("http://localhost:8080/api/supermarketSale");

            // execute request
            CloseableHttpResponse response = httpClient.execute(httpGet);

            // get response status code
            int statusCode = response.getStatusLine().getStatusCode();

            System.out.println(statusCode);

            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity, "UTF-8");
            System.out.println(body);

            response.close();
            httpClient.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    void httpClientRequestPost() {
        try (CloseableHttpClient closeableHttpClient = HttpClients.createDefault()) {

            // create post object
            HttpPost httpPost = new HttpPost("http://localhost:8080/api/supermarketSale");

            // set request body
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", 1);
            StringEntity stringEntity = new StringEntity(jsonObject.toString());
            stringEntity.setContentType("application/json");
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);

            // execute request
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);

            // get response status code
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);

            // get response body
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity, "UTF-8");
            System.out.println(body);

            response.close();
            closeableHttpClient.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
