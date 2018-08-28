package com.tanamoinc.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tanamo
 */
@Controller
public class UserContr {

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index"; //JSP - /WEB-INF/views/index.jsp
    }

}
