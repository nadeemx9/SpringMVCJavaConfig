package com.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer
{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        // In case, if WebApplicationContext file is in XML....
//        Creating WebApplicationContext object and passing location of actual XML based file.

//        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
//        webApplicationContext.setConfigLocation("WEB-INF/dispatcher-servlet.xml");
        // Creating java based WebApplicationContext.
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(SpringConfig.class);

//        1. Create DispatcherServlet object.
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

//        2. Register DispatherServlet with ServletContext.
        ServletRegistration.Dynamic mycustomdispatcherservlet = servletContext.addServlet("dispatcherservlet", dispatcherServlet);
//        mycustomdispatcherservlet.setLoadOnStartup(1);
        mycustomdispatcherservlet.addMapping("/");
    }
}
