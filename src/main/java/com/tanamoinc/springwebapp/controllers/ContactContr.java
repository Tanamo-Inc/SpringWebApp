package com.tanamoinc.springwebapp.controllers;

import com.tanamoinc.springwebapp.domain.Contact;
import com.tanamoinc.springwebapp.services.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/user/clist")
    public String contactList(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("_id");
        m.addAttribute("contactList", scon.findUserContact(userId));
        return "clist"; //JSP
    }

    @RequestMapping(value = "/user/del_contact")
    public String deleteContact(@RequestParam("cid") Integer contactId) {
        scon.delete(contactId);
        return "redirect:clist?act=del";
    }

    @RequestMapping(value = "/user/edit_contact")
    public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId) {
        session.setAttribute("id", contactId);
        Contact c = scon.findById(contactId);
        m.addAttribute("command", c);
        return "contact_form";//JSP form view
    }

    @RequestMapping(value = "/user/save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
        Integer contactId = (Integer) session.getAttribute("id");
        if (contactId == null) {
            //save task
            try {
                Integer userId = (Integer) session.getAttribute("_id");
                c.setUserId(userId);//FK ; logged in userId
                scon.save(c);
                return "redirect:clist?act=save";//redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to save contact");
                return "contact_form";
            }
        } else {
            //update task
            try {
                c.setId(contactId); //PK
                scon.update(c);
                session.removeAttribute("id");
                return "redirect:clist?act=edit";//redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to Edit contact");
                return "contact_form";
            }
        }
    }

    @RequestMapping(value = "/user/contact_search")
    public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
        Integer userId = (Integer) session.getAttribute("_id");
        m.addAttribute("contactList", scon.findUserContact(userId, freeText));
        return "clist"; //JSP
    }

    @RequestMapping(value = "/user/bulk_cdelete")
    public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
        scon.delete(contactIds);
        return "redirect:clist?act=del";
    }

}
