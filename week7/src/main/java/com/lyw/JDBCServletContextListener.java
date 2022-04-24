package com.lyw;



import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    Connection con=null;

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context=sce.getServletContext();
        String driver=context.getInitParameter("driver");//<param-name>driver</param-name>
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("init()--> " + con);// ok(java code)- ok(use config-in web.xml) -- ok -use( @webservlet )--> (use context) ok-- use mysql ( no need to change in java code )

        context.setAttribute("con",con);
    }


    public void contextDestroyed(ServletContextEvent sce) {

    }
}
