package org.zane.server;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.*;
import org.zane.JwtUtils;
import org.zane.entity.Employee;
import org.zane.enumeration.OperationType;
import org.zane.properties.JwtProperties;
import org.zane.server.mapper.EmployeeMapper;
import org.zane.server.service.EmployeeService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class ServerApplicationTests {

    private final JwtProperties jwtProperties;
    private final EmployeeMapper employeeMapper;
    private final RedisTemplate<String, Object> redisTemplate;
    private final EmployeeService employeeService;

    @Autowired
    public ServerApplicationTests(JwtProperties jwtProperties, EmployeeMapper employeeMapper, RedisTemplate<String, Object> redisTemplate, EmployeeService employeeService){
        this.jwtProperties = jwtProperties;
        this.employeeMapper = employeeMapper;
        this.redisTemplate = redisTemplate;
        this.employeeService = employeeService;
    }

    @Test
    void test() {
        System.out.println(jwtProperties.getAdminSecretKey());
    }


    @Test
    void jwtTest() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "zane");
        String result = JwtUtils.generateJwt(claims);

        System.out.println(result);

        Claims parse = JwtUtils.parseJwt(result);

        String test = parse.get("username").toString();

    }

    @Test
    void ttest() {
        log.info("hello world");
        System.out.println("heeelllo worrlddd");
    }

    @Test
    void tttest() {
        String result = OperationType.INSERT.toString();

        OperationType operationType = OperationType.INSERT;

        System.out.println(result);
        System.out.println(operationType);

        /*
        INSERT
        INSERT
         */
    }

    @Test
    public void redisTemplateTest() {
        System.out.println(redisTemplate);

        // string
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        // hash
        HashOperations hashOperations = redisTemplate.opsForHash();
        // list
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        // set
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        // zset
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();

        // manipulate string
        // set get setex setnx
        valueOperations.set("name", "zane");
        System.out.println(valueOperations.get("name"));

        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);

        // setex 有效60sec
        valueOperations.set("code", "123456", 60, TimeUnit.SECONDS);

        // manipulate hash
        hashOperations.put("employee", "name", "zane");
        hashOperations.put("employee", "username", "zane");
        hashOperations.put("employee", "password", "zane");

        String nameInHash = (String) hashOperations.get("employee", "name");

        Set hashKeys = hashOperations.keys("employee");
        System.out.println("hashKeys: " + hashKeys);

        List hashValues = hashOperations.values("employee");
        System.out.println("hashValues: " + hashValues);

        hashOperations.delete("employee", "name");


    }

    @Test
    public void httpClientGetTest() throws IOException, JSONException {
        // get request

        CloseableHttpClient httpClient = HttpClients.createDefault(); // create http client object

        HttpGet httpGet = new HttpGet("http://localhost:8080/api/admin/employees"); // create http get object

        CloseableHttpResponse response = httpClient.execute(httpGet); // execute http get request

        int statusCode = response.getStatusLine().getStatusCode(); // get status code

        HttpEntity entity = response.getEntity(); // get response body
        String responseBody = EntityUtils.toString(entity);

        System.out.println(statusCode);
        System.out.println(responseBody);

        // close http client
        response.close();
        httpClient.close();

    }

    @Test
    void httpClientPostTest() throws JSONException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault(); // create http client object

        // post request
        HttpPost httpPost = new HttpPost("http://localhost:8080/api/admin/employees");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "asxsax"); // put key value pair
        jsonObject.put("username", "xsaxas");
        jsonObject.put("password", "xsaxsas");
        jsonObject.put("phone", "3123121");
        jsonObject.put("sex", "1");
        jsonObject.put("idNumber", "2132");
        jsonObject.put("status", "1");


        StringEntity stringEntity = new StringEntity(jsonObject.toString()); // parameter is 實際上json string 的內容，但一個一個打太累了，所以需要JsonObject來快速產生json string

        stringEntity.setContentEncoding("UTF-8"); // 指定編碼方式
        stringEntity.setContentType("application/json"); // 指定content type  為json

        httpPost.setEntity(stringEntity); // set request body, 因為裡面需要傳json string, 所以要用stringEntity

        CloseableHttpResponse responsePost = httpClient.execute(httpPost);

        int statusCode1 = responsePost.getStatusLine().getStatusCode();

        HttpEntity entity1 = responsePost.getEntity();
        String postBody = EntityUtils.toString(entity1);

        System.out.println(statusCode1);
        System.out.println(postBody);

        httpClient.close();
        responsePost.close();
    }

    @Test
    void sqlToRedisTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Employee> employees = employeeMapper.selectEmployee(null);

        /*原本list<Employee> 不能直接存進redis, 我就根據chatgpt advice 使用 jackson objectMapper 把list 轉成json string, 結果一直跟我說localTime 沒辦法被轉換

        後來我把employee implement serializable 就成功

         */
        redisTemplate.opsForValue().set("employees", employees);

        List<Employee> result = (List<Employee>) redisTemplate.opsForValue().get("employees");


        System.out.println(result);

    }

    @Test
    void redisDelete(){
        redisTemplate.delete("employees");
    }







}
