package com.boot.journal.webservices.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Feature {
	@ Id 
	@ GeneratedValue( strategy = GenerationType.AUTO)  
	private int id;
	private String name;
	private String description;
	private String imageUrl;
	private String iconUrl;
	private boolean enabled;
	
	public Feature() {}

	public Feature(String name, String description, String imageUrl, String iconUrl, boolean enabled) {
		super();
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.iconUrl = iconUrl;
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
