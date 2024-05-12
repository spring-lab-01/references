package com.example.postgresjsonb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Iterable<Customer> findByLastName(String lastName);

}
