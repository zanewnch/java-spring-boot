package org.zanewnch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Integer number;
    private Integer age;
    private String gender;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
