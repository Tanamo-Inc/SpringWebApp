package com.tanamoinc.springwebapp.controllers;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tanamo
 *
 *
 * Controller methods are the final destination point that a web request can
 * reach. It starts to process the web request by interacting with the service
 * layer to complete the work that needs to be done.
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
