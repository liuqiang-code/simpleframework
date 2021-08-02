package com.bigstrong.dao.dto;

import com.bigstrong.dao.bo.HeadLine;
import com.bigstrong.dao.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * User: BigStrong
 * Date: 2021/7/18
 * Description: No Description
 */
@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
