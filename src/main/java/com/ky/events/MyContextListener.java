package com.ky.events;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application is deploying");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application is going to terminate");
    }
}
