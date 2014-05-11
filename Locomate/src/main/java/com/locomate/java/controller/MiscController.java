package com.locomate.java.controller;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MiscController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		logger.info("About Us page");
		model.addAttribute("year", Calendar.getInstance().get(Calendar.YEAR));		
		return "about";
	}
	
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String team(Model model) {
		logger.info("Team page");
		model.addAttribute("year", Calendar.getInstance().get(Calendar.YEAR));		
		return "team";
	}
	
	@RequestMapping(value = "/terms", method = RequestMethod.GET)
	public String terms(Model model) {
		logger.info("Terms page");
		model.addAttribute("year", Calendar.getInstance().get(Calendar.YEAR));		
		return "terms";
	}
	@RequestMapping(value = "/chpass", method = RequestMethod.GET)
	public String chpass(Model model) {
		logger.info("Terms page");
		model.addAttribute("year", Calendar.getInstance().get(Calendar.YEAR));		
		return "changePassword";
	}
	@RequestMapping(value = "/offer", method = RequestMethod.GET)
	public String offer(Model model) {
		logger.info("offer");
		model.addAttribute("year", Calendar.getInstance().get(Calendar.YEAR));		
		return "offer";
	}
	
	@RequestMapping(value="/file",method=RequestMethod.GET)
	public String fileUpload(Model model) {
		logger.info("fileupload");
		model.addAttribute("year", Calendar.getInstance().get(Calendar.YEAR));		
		return "fileUpload";
	}
	
	@RequestMapping(value="/imageuploader",method=RequestMethod.GET)
	public String imageUpload(Model model) {
		logger.info("fileupload");
		model.addAttribute("year", Calendar.getInstance().get(Calendar.YEAR));		
		return "ImageUploader";
	}
}
