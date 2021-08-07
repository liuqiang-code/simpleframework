package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * User: BigStrong
 * Date: 2021/8/3
 * Description: No Description
 */
public class ClassUtilTest {
    @Test
    @DisplayName("提取目标类方法：extractPackageClassTest")
    public void extractPackageClassTest() {
        Set<Class<?>> classes = ClassUtil.extractPackageClass("demo.reflect");
        for (Class<?> aClass : classes) {
            System.out.println(aClass);
        }
        Assertions.assertEquals(5, classes.size());
    }
}
