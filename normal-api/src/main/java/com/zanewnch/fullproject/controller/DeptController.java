package com.zanewnch.fullproject.controller;

import com.zanewnch.fullproject.model.Dept;
import com.zanewnch.fullproject.service.DeptService;
import com.zanewnch.fullproject.service.EmpService;
import com.zanewnch.fullproject.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
The mission of controller is:
1. receive parameter from frontend
2. response data to frontend
 */
/*
controller 是以database table 去做分類，也就是一個database table 會擁有一條controller-service-mapper 的 logical chain
 */

/*
The parameter of method of controller are pass by frontend.

The passing path of parameter is:
frontend -> controller -> service -> mapper(xml)

The passing path of return value is:
mapper(xml):return List<entity> -> service: return List<entity> -> controller: return Result class -> frontend

 */


// The @Slf4j annotation is used to generate a logger object named "logger" in the class, which is equal to the following code:
// private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

/*
@RestController = @Controller + @ResponseBody
按照原本的Result class, 他會傳回一個 Result object, 但因為 @ResponseBody(which in @RestController), 所以這個Result class 會被轉成json的格式,再傳給frontend

@RequestBody : turn json received from frontend into java object
@ResponseBody: turn java object into json, then send to frontend

原本return的Result object 會長這樣：
Result(code=1, msg=success, data=null)
但經過@ResponseBody後，會變成：
{
"code": 1,
"msg": "success",
"data": null
}
field name 會變成 json 的 key
field value 會變成 json 的 value
 */
/*
如果在整個class 加上@RequestMapping("/path"), 那這個class 下的所有method 都會有這個path, 就不需要個別再寫
但如果有攜帶路徑參數，那method上需要寫額外的path
ex;original: @RequestMapping("/depts/{id}")
after @RequestMapping : @RequestMapping("/{id}")
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    /*
    每一個layer都要@autowired import next layer's class/interface.

    要注意這裡的declare 是用interface, 而不是用class
    我們只要declare interface, IOC container 就會自動找到這個interface 的 implement 來 inject, 這個叫叫做Dependency Injection.
     */
    @Autowired
    private DeptService deptService;

    //    日誌撰寫
//    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);


    /*
    當使用@GetMapping, 就代表只有GET request的時候才會invoke this method
     */
    //    when link this url, the system will invoke this method
//    第一種寫法：請求路徑為 /depts, 請求方式為 GET
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
//    第二種寫法如下：較為簡潔

    /**
     * Search all data of department.
     *
     * @return Return Result object
     */
    @GetMapping("/allDepts")
    public Result list() {
        log.info("Search all data of department");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }


    /*
    用entity class 去receive parameter
    是前端傳來的parameter, so using @RequestBody
    @RequestBody, 接收前端傳過來的json,  並將其轉換成java object
    然後這個case當中 希望把json 轉換成Dept object
     */

    /**
     * Add data of department.
     *
     * @return Return Result object without data
     * @RequestBody receive parameter from frontend
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("Add data of department :" + dept);
        deptService.add(dept);
        return Result.success();
    }

    /*
    receive parameter pass from frontend by @PathVariable
    這個邏輯就是一層layer 會收parameter, 然後再傳到下一層layer
    所以每一層layer 都需要receive parameter (一個傳，一個收)
     */

    /*
    The way of passing parameter is using path variable.
    And then the way to receive parameter by path variable is using @PathVariable, and the value in annotation need to use {parameterName}
     */

    /**
     * Delete data of department by id.
     *
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("Delete data of department by id : " + id);
        deptService.delete(id);
//        without return the data
        return Result.success();
    }


}
