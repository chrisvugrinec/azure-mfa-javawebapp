package com.microsoft.demo.azuremfaspringboot.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.demo.azuremfaspringboot.Application;


@ComponentScan(basePackages="com.microsoft.demo.azuremfaspringboot.controllers")
@Controller
public class WebErrorController implements ErrorController {
		
	private static final Logger logger = Logger.getLogger(WebErrorController.class.getName());

	
	@RequestMapping(value = "/error")
	public ModelAndView handleError(HttpServletRequest req, Error error) {
	    logger.info("Request: " + req.getRequestURL() + " raised " + error.getMessage());
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("errors", error.getMessage());
	    mav.setViewName("error");
	    return mav;
	  }


	@Override
	public String getErrorPath() {
		return "error";
	}
 

}
