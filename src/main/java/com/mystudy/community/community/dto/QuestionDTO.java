package com.mystudy.community.community.dto;

import com.mystudy.community.community.model.User;
import lombok.Data;

/**
 * @描述
 * @创建人 CYH
 * @创建时间 2020/6/27
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer creator;
    private Integer commentCount;
    private Integer likeCount;
    private Integer viewCount;
    private User user;
}
