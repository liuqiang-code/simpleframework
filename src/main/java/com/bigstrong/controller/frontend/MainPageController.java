package com.bigstrong.controller.frontend;

import com.bigstrong.dao.dto.MainPageInfoDTO;
import com.bigstrong.dao.dto.Result;
import com.bigstrong.service.combine.HeadLineShopCategoryCombineService;
import org.simpleframework.core.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: BigStrong
 * Date: 2021/7/18
 * Description: No Description
 */
@Controller
public class MainPageController {

    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp) {
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
