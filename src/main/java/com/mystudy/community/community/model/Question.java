package com.mystudy.community.community.model;

import lombok.Data;

/**
 * @描述
 * @创建人 CYH
 * @创建时间 2020/5/23
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer creator;
    private Integer commentCount;
    private Integer likeCount;
}
