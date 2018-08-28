package com.tanamoinc.springwebapp.test;

import com.tanamoinc.springwebapp.config.SpringRoot;
import com.tanamoinc.springwebapp.dao.UserDAO;
import com.tanamoinc.springwebapp.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Tanamo
 */
public class UserDAOFindAll {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRoot.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);

        List<User> users = userDAO.findAll();
        for (User u : users) {
            System.out.println(u.getId() + " " + u.getName() + " " + u.getRole());

        }

    }

}
