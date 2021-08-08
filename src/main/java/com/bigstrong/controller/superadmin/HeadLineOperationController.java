package com.bigstrong.controller.superadmin;

import com.bigstrong.dao.bo.HeadLine;
import com.bigstrong.dao.dto.Result;
import com.bigstrong.service.sole.HeadLineService;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * User: BigStrong
 * Date: 2021/7/18
 * Description: No Description
 */
@Controller
public class HeadLineOperationController {
    @Autowired
    private HeadLineService headLineService;

    Result<Boolean> addHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        // TODO 参数校验以及请求参数转换
        return headLineService.addHeadLine(new HeadLine());
    }

    Result<Boolean> removeHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        // TODO 参数校验以及请求参数转换
        return headLineService.removeHeadLine(1);
    }

    Result<Boolean> modifyHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        // TODO 参数校验以及请求参数转换
        return headLineService.modifyHeadLine(new HeadLine());
    }

    Result<HeadLine> queryHeadLineById(HttpServletRequest req, HttpServletResponse resp) {
        // TODO 参数校验以及请求参数转换
        return headLineService.queryHeadLineById(1);
    }

    Result<List<HeadLine>>queryHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        // TODO 参数校验以及请求参数转换
        return headLineService.queryHeadLine(null, 1, 100);
    }

}
