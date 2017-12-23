package com.boot.journal.webservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.boot.journal.models.Quote;
import com.boot.journal.webservices.models.Order;

@Component
public class OrderService {

	@Autowired
	private RestOperations restOperations;	
	private final String url;
		
	@Autowired
	public OrderService(@Value("${endpoint.url}") final String url) {
		this.url = url;
	}	
	
	public Quote getQuote() {	
		return restOperations.getForObject(url,Quote.class);
	}	
	
}
