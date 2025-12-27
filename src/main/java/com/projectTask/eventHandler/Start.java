package com.projectTask.eventHandler;

import java.sql.Connection;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.projectTask.dao.ConnectionFactoryImpl;




@WebListener
public class Start implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection connection = null;
        try {
            System.out.println("ProjectTask Application Starting...");

            connection = new ConnectionFactoryImpl().getConnection();
            
            // this method use to create a tables for entered projects.
            System.out.println(connection);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ProjectTask Application Stopped.");
    }
}
