package com.bigstrong.service.sole.impl;

import com.bigstrong.dao.bo.ShopCategory;
import com.bigstrong.dao.dto.Result;
import com.bigstrong.service.sole.ShopCategoryService;

import java.util.List;

/**
 * User: BigStrong
 * Date: 2021/7/18
 * Description: No Description
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
