package com.test.FWD.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//用户管理表对应的实体类

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id = 0;
    private String email;
    private String password;
    private String username;
    private String salt;
}
