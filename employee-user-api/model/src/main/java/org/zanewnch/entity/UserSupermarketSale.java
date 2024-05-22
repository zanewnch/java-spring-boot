package org.zanewnch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSupermarketSale implements Serializable {
    private String username;
    private String password;
    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginDate;
    private String userStatus;
}
