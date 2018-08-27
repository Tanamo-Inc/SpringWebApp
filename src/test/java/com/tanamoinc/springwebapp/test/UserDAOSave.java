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
public class UserDAOSave {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRoot.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);

        User u = new User();
        u.setName("Tony");
        u.setPhone("0200200200");
        u.setEmail("tanamoinc@gmail.com");
        u.setAddress("Kumasi");
        u.setLoginName("tony");
        u.setPassword("tony");
        u.setRole(1);
        u.setLoginStatus(1);
        userDAO.save(u);
        System.out.println("*****Data Saved******");
    }

}
