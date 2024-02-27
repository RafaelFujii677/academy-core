package br.com.academycore.adapters.configuration;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.academycore.adapters.ports.percistence.CustomerRepositoryJpa;
import br.com.academycore.adapters.ports.percistence.PhoneRepositoryJpa;
import br.com.academycore.adapters.ports.percistence.impl.CustomerRepositoryImpl;
import br.com.academycore.adapters.ports.percistence.impl.PhoneRepositoryImpl;
import br.com.academycore.core.repositories.CustomerRepository;
import br.com.academycore.core.repositories.PhoneRepository;
import br.com.academycore.core.usecases.AttachOwnerPhone;
import br.com.academycore.core.usecases.CreateAndSetOwnerPhone;
import br.com.academycore.core.usecases.CreateCustomer;
import br.com.academycore.core.usecases.DeleteCustomer;

@Configuration
public class BeansConfiguration implements Serializable{
	private static final long serialVersionUID = 1L;

	@Bean
	CustomerRepository customerRepository(CustomerRepositoryJpa customerRepositoryJpa) {
		return new CustomerRepositoryImpl(customerRepositoryJpa);
	}

	@Bean
	PhoneRepository phoneRepository(PhoneRepositoryJpa phoneRepositoryJpa) {
		return new PhoneRepositoryImpl(phoneRepositoryJpa);
	}

	@Bean
	CreateCustomer createCustomer(CustomerRepository customerRepository) {
		return new CreateCustomer(customerRepository);
	}

	@Bean
	DeleteCustomer deleteCustomer(CustomerRepository customerRepository) {
		return new DeleteCustomer(customerRepository);
	}

	@Bean
	CreateAndSetOwnerPhone createAndSetOwnerPhone(PhoneRepository phoneRepository, CustomerRepository customerRepository) {
		return new CreateAndSetOwnerPhone(phoneRepository, customerRepository);
	}

	@Bean
	AttachOwnerPhone attachOwnerPhone(PhoneRepository phoneRepository, CustomerRepository customerRepository) {
		return new AttachOwnerPhone(phoneRepository, customerRepository);
	}

}
