package br.com.academycore.core.usecases;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import br.com.academycore.core.repositories.CustomerRepository;
import br.com.academycore.core.usecases.requests.CreateCustomerRequestData;
import jakarta.transaction.Transactional;

public class CreateCustomer implements Serializable{
	private static final long serialVersionUID = 1L;

	private final CustomerRepository customerRepository;

	public CreateCustomer(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Transactional
	public CreateCustomerRequestData perform(CreateCustomerRequestData createCustomerRequestData) throws Exception{
		if(createCustomerRequestData == null) throw new Exception("Customer cannot be null.");
		if(!StringUtils.isNotBlank(createCustomerRequestData.getNameCustomer())) throw new Exception("Customer name cannot be empty.");

		return CreateCustomerRequestData.toRequestData(customerRepository.save(CreateCustomerRequestData.fromRequestData(createCustomerRequestData)));
	}
}
