package com.tanamoinc.springwebapp.test;

import com.tanamoinc.springwebapp.config.SpringRoot;
import com.tanamoinc.springwebapp.dao.ContactDAO;
import com.tanamoinc.springwebapp.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Tanamo
 */
public class ContactDAOSave {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRoot.class);
        ContactDAO userDAO = ctx.getBean(ContactDAO.class);

        Contact con = new Contact();
        con.setcName("Tony");
        con.setPhone("0200200200");
        con.setEmail("tanamoinc@gmail.com");
        con.setAddress("Kumasi");
        userDAO.save(con);
        System.out.println("*****Data Saved******");
    }

}
