package com.bigstrong.service.sole;

import com.bigstrong.dao.bo.ShopCategory;
import com.bigstrong.dao.dto.Result;

import java.util.List;

/**
 * User: BigStrong
 * Date: 2021/7/18
 * Description: No Description
 */
public interface ShopCategoryService {
    Result<Boolean> addShopCategory(ShopCategory shopCategory);
    Result<Boolean> removeShopCategory(int shopCategoryId);
    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);
    Result<ShopCategory> queryShopCategoryById(int shopCategoryId);
    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}
