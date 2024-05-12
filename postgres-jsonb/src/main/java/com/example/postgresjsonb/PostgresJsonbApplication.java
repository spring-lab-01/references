package com.example.postgresjsonb;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PostgresJsonbApplication {

	private static final Logger log = LoggerFactory.getLogger(PostgresJsonbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PostgresJsonbApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			Address address = new Address();
			address.setCity("Delhi");
			address.setCountry("India");
			address.setState("Delhi");
			address.setStreet("1");
			
			Address address1 = new Address();
			address1.setCity("Mumbai");
			address1.setCountry("India");
			address1.setState("MH");
			address1.setStreet("2");
			
			List<Address> addressList = new ArrayList<>();
			addressList.add(address);
			addressList.add(address1);
			
			
			// save a few customers
			repository.save(new Customer("Jack", "Bauer", addressList));
			repository.save(new Customer("Chloe", "O'Brian", addressList));
			repository.save(new Customer("Kim", "Bauer", addressList));
			repository.save(new Customer("David", "Palmer", addressList));
			repository.save(new Customer("Michelle", "Dessler", addressList));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<Customer> customer = repository.findById(1L);
			if (customer.isPresent()) {
				log.info("Customer found with findById(1L):");
				log.info("--------------------------------");
				log.info(customer.get().toString());
				log.info("");
			}

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}
