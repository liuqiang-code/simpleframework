package demo.pattern.proxy.demo.impl;

import demo.pattern.proxy.demo.LogInterface;

/**
 * User: BigStrong
 * Date: 2021/9/5
 * Description: No Description
 */
public class LogInterfaceImpl implements LogInterface {
    @Override
    public void log() {
        System.out.println("记录日志");
    }
}
