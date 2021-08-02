package com.bigstrong.dao.bo;

import lombok.Data;

import java.util.Date;

/**
 * User: BigStrong
 * Date: 2021/7/17
 * Description: No Description
 */
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
