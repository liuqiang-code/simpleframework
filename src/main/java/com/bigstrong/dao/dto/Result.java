package com.bigstrong.dao.dto;

import lombok.Data;

/**
 * User: BigStrong
 * Date: 2021/7/18
 * Description: No Description
 */
@Data
public class Result<T> {
    // 本次请求结果的状态吗
    private String code;

    // 本次请求结果的详情
    private String mes;

    // 本次请求返回的结果集
    private T data;
}
