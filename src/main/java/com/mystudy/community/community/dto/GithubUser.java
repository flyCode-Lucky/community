package com.mystudy.community.community.dto;

import lombok.Data;

/**
 * @描述
 * @创建人 ChenYuHuan
 * @创建时间 2020/4/24
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
