package org.simpleframework.core;

import com.bigstrong.controller.frontend.MainPageController;
import com.bigstrong.service.sole.HeadLineService;
import com.bigstrong.service.sole.impl.HeadLineServiceImpl;
import org.junit.jupiter.api.*;
import org.simpleframework.core.annotation.Controller;

/**
 * User: BigStrong
 * Date: 2021/8/7
 * Description: No Description
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {

    private static BeanContainer beanContainer = BeanContainer.getInstance();

    @Test
    @Order(1)
    @DisplayName("加载目标类及其实例到BeanContainer:loadBeansTest")
    public void loadBeansTest() {
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.bigstrong");
        Assertions.assertEquals(6, beanContainer.size());
        Assertions.assertEquals(true, beanContainer.isLoaded());
    }

    @Test
    @Order(2)
    @DisplayName("根据类获取其实例：getBeanTest")
    public void getBeanTest() throws ClassNotFoundException {
        MainPageController bean = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true, bean instanceof MainPageController);
        Object dispatcherObj = beanContainer.getBean(Class.forName("com.bigstrong.controller.DispatcherServlet"));
        Assertions.assertEquals(true, dispatcherObj == null);
    }

    @Test
    @Order(3)
    @DisplayName("根据注解获取对应的实例：getClassByAnnotationTest")
    public void getClassesByAnnotationTest() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(3 , beanContainer.getClassesByAnnotation(Controller.class).size());
    }

    @Test
    @Order(4)
    @DisplayName("根据接口获取实例：getClassesBySuperTest")
    public void getClassesBySuperTest() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(true, beanContainer.getClassesBySuper(HeadLineService.class).contains(HeadLineServiceImpl.class));
    }

}
