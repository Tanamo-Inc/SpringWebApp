package com.tanamoinc.springwebapp.test;

import com.tanamoinc.springwebapp.config.SpringRoot;
import com.tanamoinc.springwebapp.domain.User;
import com.tanamoinc.springwebapp.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Tanamo
 */
public class UserServiceRegister {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRoot.class);
        UserService userService = ctx.getBean(UserService.class);
        User u = new User();
        u.setName("Tanamo");
        u.setPhone("020020");
        u.setEmail("ta@tanamo.org");
        u.setAddress("Knust");
        u.setLoginName("tt");
        u.setPassword("tt");
        u.setRole(UserService.ROLE_ADMIN);
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        userService.register(u);
        System.out.println("*******User Registered Successfully*******");
    }

}
