package com.my.test.web.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class HelloServlet implements Servlet {

    /**
     * 非常重要：代表当前web应用，可以获取当前web应用的各种信息
     */
    private ServletContext servletContext;

    public HelloServlet() {
        System.out.println("HelloServlet's constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String user = config.getInitParameter("user");
        System.out.println(user);
        Enumeration parameterNames = config.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
        servletContext = config.getServletContext();
        System.out.println("->> init ServletName=" + config.getServletName());

        Enumeration initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String key = (String) initParameterNames.nextElement();
            System.out.println(key + "=" + servletContext.getInitParameter(key));
        }
        System.out.println(servletContext.getContextPath());
        System.out.println(servletContext.getServletContextName());
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service");
        ServletOutputStream outputStream = res.getOutputStream();
        outputStream.write("HelloServlet".getBytes());
//        outputStream.flush();
        res.flushBuffer();

        System.out.println(servletContext.getRealPath("/index.jsp"));
        System.out.println(servletContext.getRealPath("/jdbc.properties"));

        InputStream inputStream1 = getClass().getClassLoader().getResourceAsStream("/jdbc.properties");
        InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
        System.out.println("1 " + inputStream1);
        System.out.println("2 " + inputStream);
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
