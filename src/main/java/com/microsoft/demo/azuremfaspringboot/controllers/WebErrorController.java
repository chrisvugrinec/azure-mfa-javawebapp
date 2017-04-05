package com.microsoft.demo.azuremfaspringboot.controllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan(basePackages = "com.microsoft.demo.azuremfaspringboot.controllers")
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
