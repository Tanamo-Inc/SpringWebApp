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
public class UserDAOUpdate {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRoot.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);

        User u = new User();
        u.setId(2);
        u.setName("Tandoh Anthony");
        u.setPhone("0201302034");
        u.setEmail("antandoh.nsp@knustedu.gh");
        u.setAddress("Kumasi, knust");
        u.setRole(2);
        u.setLoginStatus(1);
        userDAO.update(u);

        System.out.println("*******USER Updated*********");
    }

}
