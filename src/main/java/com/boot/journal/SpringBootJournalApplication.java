package com.boot.journal;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.boot.journal.interfaces.FeaturesRepository;
import com.boot.journal.interfaces.JournalRepository;
import com.boot.journal.models.Journal;
import com.boot.journal.webservices.models.Feature;
import com.boot.journal.webservices.services.OrderService;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootJournalApplication {
	
	@Autowired
	private OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJournalApplication.class, args);
	}
		
	@Bean
	InitializingBean saveData(JournalRepository repo, FeaturesRepository repo2) {
			return()->{
				repo.save(new Journal("J1","JA1","2017-12-12"));
				repo.save(new Journal("J2","JA2","2017-12-12"));
				repo.save(new Journal("J3","JA3","2017-12-12"));
				repo.save(new Journal("J4","JA4","2017-12-12"));
				
				repo2.save(new Feature("Au labo", "Recevez vos commandes et les préparer dans le laboratoire", "kitchen.png", "kitchen.png", true));

				repo2.save(new Feature("Au Kiosk", "Recevez vos commandes et les préparer dans le laboratoire", "kiosk.png",  "kiosk.png", true));

				repo2.save(new Feature("Remise de commandes", "Terminer les commandes et les remettre aux clients", "checkout.png", "checkout.png", true));

				repo2.save(new Feature("Historique", "Visualiser et trier l'historique de vos commandes", "historique.png", "historique.png", true));
				
				repo2.save(new Feature("Statistiques", "Editer un bilan de vos commandes", "analytics.png", "analytics.png", true));
		};
	}
}
