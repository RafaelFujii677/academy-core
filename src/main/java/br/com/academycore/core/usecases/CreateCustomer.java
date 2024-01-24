package br.com.academycore.core.usecases;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import br.com.academycore.core.domains.CustomerDomain;
import br.com.academycore.core.repositories.CustomerRepository;
import br.com.academycore.core.usecases.requests.CreateCustomerRequestData;
import jakarta.transaction.Transactional;

public class CreateCustomer implements Serializable{
	private static final long serialVersionUID = 1L;

	private final ModelMapper mapper;
	private final CustomerRepository customerRepository;

	public CreateCustomer(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
		this.mapper = new ModelMapper();
	}

	@Transactional
	public UUID perform(CreateCustomerRequestData createCustomerRequestData) throws Exception{
		if(createCustomerRequestData == null) throw new Exception("Customer cannot be null.");
		if(!StringUtils.isNotBlank(createCustomerRequestData.getNameCustomer())) throw new Exception("Customer name cannot be empty.");

		return customerRepository.save(mapper.map(createCustomerRequestData, CustomerDomain.class));
	}
}
