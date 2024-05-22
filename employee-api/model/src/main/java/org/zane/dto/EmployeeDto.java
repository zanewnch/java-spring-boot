package org.zane.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String sex;
    private String idNumber;
}
