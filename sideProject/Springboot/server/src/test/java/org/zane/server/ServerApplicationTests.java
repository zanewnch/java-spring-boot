package org.zane.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void syntaxTest(){
        Map<String,String> map = new HashMap<>();
        map.put("a","b");
        map.put("c","d");
        System.out.println(map);

        List<Map<Integer,Integer>> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Map<Integer,Integer> map2 = new HashMap<>();
            map2.put(i,i+1);
            list.add(map2);
        }



    }

}
