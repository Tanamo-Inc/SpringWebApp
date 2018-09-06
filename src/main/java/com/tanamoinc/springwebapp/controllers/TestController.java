package com.tanamoinc.springwebapp.controllers;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tanamo
 */
@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String helloWorld() {
        return "hello"; // -> /WEB-INF/views/hello.jsp
    }

    @RequestMapping("/test/ajax_test")
    public String testPage() {
        return "test";
    }

    @RequestMapping("/test/get_time")
    @ResponseBody
    public String getServerTime() {
        System.out.println("*******getServerTime()******");
        Date d = new Date();
        return d.toString();
    }

}
