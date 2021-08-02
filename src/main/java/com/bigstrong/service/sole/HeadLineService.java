package com.bigstrong.service.sole;

import com.bigstrong.dao.bo.HeadLine;
import com.bigstrong.dao.dto.Result;
import java.util.List;

/**
 * User: BigStrong
 * Date: 2021/7/18
 * Description: No Description
 */
public interface HeadLineService {
    Result<Boolean> addHeadLine(HeadLine headLine);
    Result<Boolean> removeHeadLine(int headLineId);
    Result<Boolean> modifyHeadLine(HeadLine headLine);
    Result<HeadLine> queryHeadLineById(int headLineId);
    Result<List<HeadLine>>queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize);
}
