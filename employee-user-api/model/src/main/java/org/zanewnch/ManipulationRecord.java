package org.zanewnch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManipulationRecord {
    private Integer id;
    private Integer manipulationUser;
    private LocalDateTime manipulationTime;
    private String className;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private Long runTime;


}
