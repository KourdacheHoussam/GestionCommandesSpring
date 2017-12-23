package com.boot.journal.webservices.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import com.boot.journal.webservices.models.Feature;

@Component
public class FeatureService {

	@Autowired
	private RestOperations restOperations;	
	private final String url;
		
	@Autowired
	public FeatureService(@Value("${endpoint.url}") final String url) {
		this.url = url;
	}	
	
	public Feature[] getFeatures() {	
		return restOperations.getForObject(url,Feature[].class);
	}	
	
}
