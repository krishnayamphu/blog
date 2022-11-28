package com.ky.events;

import com.ky.config.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application is deploying");
       // Database.run();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Database.destroy();
        System.out.println("application is going to terminate");
    }
}
