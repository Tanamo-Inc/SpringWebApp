package com.tanamoinc.springwebapp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Tanamo
 *
 * DispatcherServlet handles incoming requests and route them through Spring
 *
 * Front Controller
 */
public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringRoot.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebC.class};

    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};

    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext); //must present
        //Configure global task here if required
    }

}
