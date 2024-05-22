package org.zane;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupermarketSale implements Serializable {
    private Long id;

    private String branch;

    private String city;

    private String customerType;

    private String gender;

    private String productLine;

    private BigDecimal unitPrice;

    private int quantity;

    private BigDecimal tax5Percent;

    private BigDecimal total;

    private Date date;

    private Date time;

    private String payment;

    private BigDecimal cogs;

    private BigDecimal grossMarginPercentage;

    private BigDecimal grossIncome;

    private BigDecimal rating;
}


