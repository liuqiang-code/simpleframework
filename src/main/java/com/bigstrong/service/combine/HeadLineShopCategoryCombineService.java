package com.bigstrong.service.combine;

import com.bigstrong.dao.dto.MainPageInfoDTO;
import com.bigstrong.dao.dto.Result;

/**
 * User: BigStrong
 * Date: 2021/7/18
 * Description: No Description
 */
public interface HeadLineShopCategoryCombineService {
    Result<MainPageInfoDTO> getMainPageInfo();
}
