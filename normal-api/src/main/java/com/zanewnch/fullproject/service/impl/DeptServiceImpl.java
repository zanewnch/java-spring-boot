package com.zanewnch.fullproject.service.impl;

import com.zanewnch.fullproject.mapper.DeptMapper;
import com.zanewnch.fullproject.model.Dept;
import com.zanewnch.fullproject.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/*
因為DeptServiceImpl 是 implements DeptService, 所以要加上@override 來實作DeptService的方法
 */

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
//    因為frontend 傳來的json data, 關於dept 的filed 並不完整，也就是其他filed of dept are null, 這樣並不能直接insert into database, 所以要在service layer 進行補全filed
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.add(dept);
    }

    /*
    roll back: 取消transaction當中的所有操作，包括已經執行的跟尚未執行的，假設在沒有創建子transaction的情況下發生exception, 那就會roll back, 導致finally 裡面的code 也不會被執行；但如果有創建子transaction,那子transaction 就不會理會主transaction 的roll back, 會執行子transaction's code.
     */
    /*
    Transaction:

    With @Transactional, all manipulation of mapper will combine into one transaction.
    When occurs exception, all manipulation would roll back, which means all manipulation would be canceled.

    The rollbackFor = Exception.class attribute is mean process rollback when facing anytype of exception.

    propagation = Propagation.REQUIRED which means when @transaction method A invokes @transaction method B, the method B would use the same transctional created by method A, in the other words, when A occurs exception, the B would also roll back(do not run).
    被invoke的時候，如果有transaction就加入該transaction,如果沒有，再自己create a transaction.

    propagation = Propagation.REQUIREDS_NEW
    在主transaction下再create an independent transaction, no matter the main transaction occurs exception, the sub-transaction would run.
    白話來講，如果有子transaction, 就是脫離主transaction, 不會被roll back.
    (Suspending current transaction, creating new transaction with name [...])
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public List<Dept> transactionalTest() {
        try {


            List<Dept> dept = deptMapper.selectDept();

            List<Dept> emp = deptMapper.selectEmp();

            return dept;


        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException("transactionalTest failed");
        } finally {
            /*
            這邊使用finally的意義是不管怎樣都要add操作記錄到log table, 但我懶得寫，所以先隨便用一個print statement來代替
            下面的return 也是隨便寫的
             */
            System.out.println("finally");
        }
        return deptMapper.selectDept();
    }


}
