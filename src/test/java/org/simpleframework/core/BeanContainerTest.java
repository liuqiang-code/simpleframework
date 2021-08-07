package org.simpleframework.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * User: BigStrong
 * Date: 2021/8/7
 * Description: No Description
 */
public class BeanContainerTest {

    private static BeanContainer beanContainer = BeanContainer.getInstance();

    @Test
    @DisplayName("加载目标类及其实例到BeanContainer:loadBeansTest")
    public void loadBeansTest() {
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.bigstrong");
        Assertions.assertEquals(6, beanContainer.size());
        Assertions.assertEquals(true, beanContainer.isLoaded());
    }

}
