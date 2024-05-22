package org.zanewnch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageBean<T> {
    // totalDataAmount is the total amounts of data in the table
    private Long totalDataAmounts;
    // the select result which is List<Employee>
    private T MapperReturnValue;
}
