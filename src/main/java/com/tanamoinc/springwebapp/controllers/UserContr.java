package com.tanamoinc.springwebapp.controllers;

import com.tanamoinc.springwebapp.command.LoginCommand;
import com.tanamoinc.springwebapp.command.userCommand;
import com.tanamoinc.springwebapp.domain.User;
import com.tanamoinc.springwebapp.exceptions.UserBlockedException;
import com.tanamoinc.springwebapp.services.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
                mod.addAttribute("err", "Login Failed!");
                return "index";
            } else {
                //SUCCESS
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    userInSession(loggedInUser, session);
                    return "redirect:admin/admin_dashboard";
                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                    userInSession(loggedInUser, session);
                    return "redirect:user/user_dashboard";
                } else {
                    mod.addAttribute("err", "Invalid User ROLE");
                    return "index";
                }
            }
        } catch (UserBlockedException ex) {
            mod.addAttribute("err", ex.getMessage());
            return "index";
        }

    }

    private void userInSession(User u, HttpSession session) {
        // session.setAttribute("user", u);
        session.setAttribute("_id", u.getId());
        session.setAttribute("role", u.getRole());
    }

    @RequestMapping(value = "/user/user_dashboard")
    public String userDashBoard() {
        return "user_dashboard"; //JSP - /WEB-INF/views/user_dashboard.jsp
    }

    @RequestMapping(value = "/admin/admin_dashboard")
    public String adminDashBoard() {
        return "admin_dashboard"; //JSP - /WEB-INF/views/admin_dashboard.jsp
    }

    @RequestMapping(value = "/reg_form")
    public String registrationForm(Model m) {
        userCommand cmd = new userCommand();
        m.addAttribute("command", cmd);
        return "reg_form";//JSP
    }

    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") userCommand cmd, Model m) {
        try {
            User user = cmd.getUser();
            user.setRole(UserService.ROLE_USER);
            user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
            userService.register(user);
            return "redirect:index?act=reg";
        } catch (DuplicateKeyException e) {
            m.addAttribute("err", "Username is already registered. Please select another username.");
            return "reg_form";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index?act=lo";
    }

    @RequestMapping(value = "/admin/users")
    public String getUserList(Model m) {
        m.addAttribute("userList", userService.getUserList());
        return "users"; //JSP
    }

}
