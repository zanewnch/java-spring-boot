package com.zanewnch.springboot1.Controller;

import com.zanewnch.springboot1.pojo.Emp;
import com.zanewnch.springboot1.pojo.Result;
import com.zanewnch.springboot1.service.EmpService;
import com.zanewnch.springboot1.service.impl.EmpServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
把原先 EmpController 的edition
改良成三層架構and IOC&DI
 */



/*
@RestController = @ResponseBody + @Controller
 */
//@ResponseBody
//@Controller
@RestController(value = "EmpController")
// The default value of Bean name is 首字母小寫的classname, for example:
// empControllerNew
//但是一般都不用特別修改，直接使用default就好
public class EmpControllerNew {

    /*
    如果只有declare 但沒有assign, 那該object的value 就等於null
    會出現 nullPointerException(空指針異常)
     */
    /*
    如果在每次code運行時都new 一個instance, 當要使用的class有名稱上的變動時，那還要手動更改此code當中的new 部分(instantiate)
    這樣太麻煩
    所以變成code當中不new instance,而是把創建權交給IOC container
    所以叫做:
    Inversion of Control
     */
    /*
    @Autowired
    運行時
    IOC container 會找container當中的component, 然後注入到這裡
    所以叫做:
    dependency injection
     */
    /*
    至於IOC container 要怎麼知道要在container找哪個bean?
    : bean 會implement interface
    透過interface 去找到所有implement,且有@compoent的bean,來進行DI
    所以要declare:
    private EmpService empService;
    (decorator) (interfaceName/className) (variableName)
     */
    //    private EmpService empService = new EmpServiceA();


//    @Qualifier is springboot build-in
//    but the @Resource is provided by JDK
//  @Qualifier("empServiceA") + @Autowired
//    or @Resource(name = "empServiceA")
    @Autowired
    private EmpService empService;

    @RequestMapping("/emp")
    public Result list(){

        List<Emp> empList = empService.listEmp();

        return Result.success(empList);
    }

}
