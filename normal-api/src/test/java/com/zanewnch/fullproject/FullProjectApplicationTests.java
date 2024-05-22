package com.zanewnch.fullproject;

import com.zanewnch.fullproject.mapper.DeptMapper;
import com.zanewnch.fullproject.mapper.EmpMapper;
import com.zanewnch.fullproject.model.Dept;
import com.zanewnch.fullproject.model.Emp;
import com.zanewnch.fullproject.utils.Result;
import com.zanewnch.fullproject.utils.returnTest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
With SpringBootTest annotation, it will load the whole springboot project.
 */
@SpringBootTest
class FullProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        Result result = Result.success();
        System.out.println(result);

        returnTest test1 = new returnTest("a", 1);
        returnTest test2 = returnTest.getObject("b", 2);
        System.out.println(test1);
        System.out.println(test2);
    }

    /*
    mybatis mapper unit test
     */
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Test
    void test2() {
//        List<Dept> deptList = deptMapper.getAllDept();
//        deptList.stream()
//                .forEach(dept -> {
//                    System.out.println(dept);
//                });

        List<Emp> empList = empMapper.selectAllEmp();

    }

    /**
     * Testing  for generate the new JWT token
     */
    @Test
    void testGenJwt() {

        /*
        This Map is representing the json file,
        the key is string, and the value is object
         */
        Map<String, Object> claims =
                new HashMap<>();

        claims.put("id", 1);
        claims.put("username", "zanewnch");

        String jwt = Jwts.builder()
//                choose the algorithm of generating the sigature part of JWT token
                .signWith(SignatureAlgorithm.HS256, "zanewnch")
//                set the claims in payload part, which is the authentical place of storing data
                .setClaims(claims)
//                set the expiration time
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .compact();

        System.out.println(jwt);
    }

    @Test
    void testParseJwt() {

        Map<String, Object> claims =
                new HashMap<>();

        claims.put("id", 1);
        claims.put("username", "zanewnch");

        String jwt = Jwts.builder()

    .signWith(SignatureAlgorithm.HS256, "zanewnch").setClaims(claims).setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)).compact();


        /*
        如果密碼錯誤 那會直接runtime exception, 不是return null
         */
        Claims parseClaims = Jwts.parser().setSigningKey("zanewnch").parseClaimsJws(jwt).getBody();


        System.out.println(jwt);
        System.out.println(parseClaims);
    }

    @Test
    void calculate() {
        int tokenAmount = 500;
        double tokenPrice = 0.002 / 1000;
        double oneChat = tokenAmount * tokenPrice;
        int daily = 40;
        double result = daily * oneChat * 30;
        System.out.println(result);
    }
}
