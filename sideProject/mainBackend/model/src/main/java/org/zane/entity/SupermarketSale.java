package org.zane.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupermarketSale {
    private Long id;
    private String branch;
    private String city;
    private String customerType;
    private String gender;
    private String productLine;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal tax5Percent;
    private BigDecimal total;
    private Date date;
    private Time time;
    private String payment;
    private BigDecimal cogs;
    private BigDecimal grossMarginPercentage;
    private BigDecimal grossIncome;
    private BigDecimal rating;
}
