package com.mystudy.community.community.model;

import lombok.Data;

import javax.swing.*;

/**
 * @描述
 * @创建人 CYH
 * @创建时间 2020/5/10
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreat;
    private Long gmtModified;
    private String avatarUrl;
    private String bio;

}
