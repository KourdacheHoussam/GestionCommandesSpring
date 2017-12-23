package com.boot.journal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.boot.journal.interfaces.JournalRepository;
import com.boot.journal.models.Quote;
import com.boot.journal.webservices.services.OrderService;

import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JournalController {
	private static final Logger log = LoggerFactory.getLogger(JournalController.class);

	@Autowired 
	JournalRepository repo;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/journal")
	public String index(Model model) {
		 RestTemplate restTemplate = new RestTemplate();
	        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
	        log.info(quote.toString());
		
		model.addAttribute("journal", repo.findAll());
		
		Quote qte = orderService.getQuote();
		log.error("Quote : "+qte.getType()+" "+qte.getValue());
		
		return "index";//return the name page in templates : index.html
	}
}
