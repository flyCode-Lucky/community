package com.mystudy.community.community.dto;

import lombok.Data;

/**
 * @描述
 * @创建人 ChenYuHuan
 * @创建时间 2020/4/24
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
