package com.keymanage.listener;

import com.keymanage.utils.CertificateUtils;
import com.keymanage.validata.ValidataKey;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URLDecoder;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-1-25 Time: 下午12:57 To change this template use File |
 * Settings | File Templates.
 */
public class ValidataKeyLinstener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        new ValidataKey().Validata();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
