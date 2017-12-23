package com.boot.journal.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.journal.models.Journal;
import com.boot.journal.webservices.models.Feature;

public interface FeaturesRepository  extends JpaRepository<Feature, Long>{}
