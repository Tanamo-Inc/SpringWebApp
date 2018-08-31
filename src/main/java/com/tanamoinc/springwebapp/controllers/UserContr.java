package com.tanamoinc.springwebapp.controllers;

import com.tanamoinc.springwebapp.command.LoginCommand;
import com.tanamoinc.springwebapp.domain.User;
import com.tanamoinc.springwebapp.exceptions.UserBlockedException;
import com.tanamoinc.springwebapp.services.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tanamo
 */
@Controller
public class UserContr {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"})
    public String index(Model mod) {
        mod.addAttribute("command", new LoginCommand());
        return "index"; //JSP - /WEB-INF/views/index.jsp
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model mod, HttpSession session) {

        try {
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());

            if (loggedInUser == null) {
                //FAILED
                mod.addAttribute("err","Login Failed!");
                return "index";
            } else {
                //SUCCESS
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    return "redirect:admin/admin_dashboard";
                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                    return "redirect:user/user_dashboard";
                } else {
                    mod.addAttribute("err","Invalid User ROLE");
                    return "index";
                }
            }
        } catch (UserBlockedException ex) {
            mod.addAttribute("err", ex.getMessage());
            return "index";
        }

    }

    @RequestMapping(value = "/user/user_dashboard")
    public String userDashBoard() {
        return "user_dashboard"; //JSP - /WEB-INF/views/user_dashboard.jsp
    }

    @RequestMapping(value = "/admin/admin_dashboard")
    public String adminDashBoard() {
        return "admin_dashboard"; //JSP - /WEB-INF/views/admin_dashboard.jsp
    }

}
