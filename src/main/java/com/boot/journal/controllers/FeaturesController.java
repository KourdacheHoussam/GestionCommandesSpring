package com.boot.journal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.boot.journal.interfaces.FeaturesRepository;
import com.boot.journal.interfaces.JournalRepository;
import com.boot.journal.models.Quote;
import com.boot.journal.webservices.services.OrderService;

@Controller
public class FeaturesController {
	private static final Logger log = LoggerFactory.getLogger(JournalController.class);

	@Autowired 
	FeaturesRepository featuresRepo;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("features", featuresRepo.findAll());
		return "index";//return the name page in templates : index.html
	}
}
