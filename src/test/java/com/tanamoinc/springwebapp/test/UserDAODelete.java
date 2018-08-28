package com.tanamoinc.springwebapp.test;

import com.tanamoinc.springwebapp.config.SpringRoot;
import com.tanamoinc.springwebapp.dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Tanamo
 */
public class UserDAODelete {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRoot.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        userDAO.delete(1);
        System.out.println("*****User Deleted******");
    }

}
