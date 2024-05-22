package com.zanewnch.fullproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
The encapsulation of query
paging results
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    /*
    The order of size for number are Long -> int -> short
    Long 可以儲存的數字範圍最大，int 次之，short 最小
     */
    private Long total;
    private List<Emp> rows;

}
