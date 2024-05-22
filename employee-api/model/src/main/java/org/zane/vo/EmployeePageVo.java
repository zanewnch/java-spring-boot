package org.zane.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zane.entity.Employee;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePageVo implements Serializable {
    // totalDataAmount is the total amounts of data in the table
    private Long totalDataAmounts;
    // the select result which is List<Employee>
    private List<Employee> selectEmployees;
}
