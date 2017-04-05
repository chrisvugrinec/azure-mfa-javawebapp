package com.microsoft.demo.azuremfaspringboot.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microsoft.aad.adal4j.AuthenticationResult;


@ComponentScan(basePackages="com.microsoft.demo.azuremfaspringboot.controllers")
@Controller
public class WebController {
	

    @RequestMapping(value = "/hello", method = { RequestMethod.GET, RequestMethod.POST })
    public String defaultPage(ModelMap model, HttpServletRequest httpRequest) {
        return "hello";
    }
 
}
