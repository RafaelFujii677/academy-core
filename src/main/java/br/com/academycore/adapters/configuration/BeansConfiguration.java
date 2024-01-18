package br.com.academycore.adapters.configuration;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.academycore.core.repositories.CustomerRepository;
import br.com.academycore.core.usecases.CreateCustomer;

@Configuration
public class BeansConfiguration implements Serializable{
	private static final long serialVersionUID = 1L;

	@Bean
	CreateCustomer createCustomer(CustomerRepository customerRepository) {
		return new CreateCustomer(customerRepository);
	}

}
