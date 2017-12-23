package com.boot.journal.interfaces;

import com.boot.journal.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long>{}
