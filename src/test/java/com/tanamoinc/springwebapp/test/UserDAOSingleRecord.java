package com.tanamoinc.springwebapp.test;

import com.tanamoinc.springwebapp.config.SpringRoot;
import com.tanamoinc.springwebapp.dao.UserDAO;
import com.tanamoinc.springwebapp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Tanamo
 */
public class UserDAOSingleRecord {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRoot.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User u = userDAO.findById(2);
        System.out.println("--------User Info------");
        System.out.println(u.getId());
        System.out.println(u.getName());
        System.out.println(u.getPhone());
        System.out.println(u.getEmail());
        System.out.println(u.getAddress());
        System.out.println(u.getLoginName());
        System.out.println(u.getLoginStatus());
        System.out.println(u.getRole());
    }

}
