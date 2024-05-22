package org.zane.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginVo {

    /*
    假設登入成功，傳給前端只需要token就夠了
     */

    private String token;
}
