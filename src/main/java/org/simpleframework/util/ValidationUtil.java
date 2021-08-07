package org.simpleframework.util;

import java.util.Collection;

/**
 * User: BigStrong
 * Date: 2021/8/7
 * Description: No Description
 */
public class ValidationUtil {

    /**
     * Collection 是否为null 或者size为0
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
