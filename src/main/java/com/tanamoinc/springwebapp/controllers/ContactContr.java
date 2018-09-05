package com.tanamoinc.springwebapp.controllers;

import com.tanamoinc.springwebapp.domain.Contact;
import com.tanamoinc.springwebapp.services.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tanamo
 */
@Controller
public class ContactContr {

    @Autowired
    private ContactService scon;

    @RequestMapping(value = "/user/contact_form")
    public String fContact(Model mod) {
        Contact cont = new Contact();
        mod.addAttribute("command", cont);
        return "contact_form"; //JSP form view
    }

    @RequestMapping(value = "/user/save_contact")
    public String sContact(@ModelAttribute("command") Contact con, Model m, HttpSession session) {

        try {
            Integer cId = (Integer) session.getAttribute("_id");
            con.setUserId(cId);//FK ; logged in userId
            scon.save(con);
            return "redirect:clist?act=sv";//redirect user to contact list url
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to save contact");
            return "contact_form";
        }
    }

    @RequestMapping(value = "/user/clist")
    public String contactList(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("_id");
        m.addAttribute("contactList", scon.findUserContact(userId));
        return "clist"; //JSP
    }

}
