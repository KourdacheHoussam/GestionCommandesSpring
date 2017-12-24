package com.boot.journal.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.boot.journal.interfaces.FeaturesRepository;
import com.boot.journal.interfaces.JournalRepository;
import com.boot.journal.models.Quote;
import com.boot.journal.webservices.models.Feature;
import com.boot.journal.webservices.services.OrderService;

@Controller
public class FeaturesController {
	private static final Logger log = LoggerFactory.getLogger(JournalController.class);

	@Autowired 
	FeaturesRepository featuresRepo;
		
	@Value("${app.name}")
	private String appName;
	
	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:/features";
	}
	/**
	 * Show all features
	 * @param model
	 * @return
	 */
	@RequestMapping("/features")
	public String features(Model model) {
		model.addAttribute("features", featuresRepo.findAll());//send data to model
		model.addAttribute("pageTitle",appName );
		return "index";//return the name page in templates : index.html
	}
	/**
	 * Display View Feature
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/orders/{name}")
	public String featureView(@PathVariable String name, Model model) {
		model.addAttribute(name);
		return "orders";
	}
	
	
	
	
}
