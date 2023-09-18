package com.among.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
		@RequestMapping(value = "/memjoin", method = RequestMethod.GET)
		public String memjoin() {
			
			return "memjoin";

	}

		@RequestMapping(value = "/freeboard", method = RequestMethod.GET)
		public String freeboard() {
			
			return "freeboard";

	}
		@RequestMapping(value = "/hotboard", method = RequestMethod.GET)
		public String hotboard() {
			
			return "hotboard";

	}
		@RequestMapping(value = "/gameboard", method = RequestMethod.GET)
		public String gameboard() {
			
			return "gameboard";

	}
		@RequestMapping(value = "/foodboard", method = RequestMethod.GET)
		public String foodboard() {
			
			return "foodboard";

	}
		@RequestMapping(value = "/travleboard", method = RequestMethod.GET)
		public String travleboard() {
			
			return "travleboard";

	}
	
}
