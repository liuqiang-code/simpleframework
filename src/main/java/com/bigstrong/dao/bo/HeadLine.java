package com.bigstrong.dao.bo;

import lombok.Data;

import java.util.Date;

/**
 * User: BigStrong
 * Date: 2021/7/17
 * Description: No Description
 */
@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private  String lineLink;
    private String lineImg;
    private Integer priority;
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;
}
