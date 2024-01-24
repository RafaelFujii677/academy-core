package br.com.academycore.core.usecases;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

import br.com.academycore.core.domains.CustomerDomain;
import br.com.academycore.core.repositories.CustomerRepository;
import jakarta.transaction.Transactional;

public class DeleteCustomer implements Serializable{
	private static final long serialVersionUID = 1L;

	private CustomerRepository customerRepository;

	public DeleteCustomer(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Transactional
	public void perform(UUID idCustomer) throws Exception {
		Optional<CustomerDomain> customerOptional = customerRepository.findOneById(idCustomer);
		if(!customerOptional.isPresent()) throw new Exception("Customer not found");

		customerRepository.delete(idCustomer);
	}
}
