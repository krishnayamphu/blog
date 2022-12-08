package com.ky.events;

import com.ky.config.Database;
import com.ky.dao.PostDAO;
import com.ky.models.Post;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Database.run();
        ArrayList<Post> latestPosts= PostDAO.getLatestPosts();
        sce.getServletContext().setAttribute("latestPosts",latestPosts);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Database.destroy();
    }
}
