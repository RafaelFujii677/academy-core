package br.com.academycore.adapters.ports.percistence;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;

import br.com.academycore.core.domains.CustomerDomain;
import br.com.academycore.core.repositories.CustomerRepository;
import br.com.academycore.core.usecases.requests.CreateCustomerRequestData;

public class CustomerRepositoryImpl implements Serializable, CustomerRepository {
	private static final long serialVersionUID = 1L;

	private final CustomerRepositoryJpa customerRepositoryJpa;
	private final ModelMapper modelMapper;

	public CustomerRepositoryImpl(CustomerRepositoryJpa customerRepositoryJpa) {
		this.modelMapper = new ModelMapper();
		this.customerRepositoryJpa = customerRepositoryJpa;
	}

	@Override
	public UUID save(CreateCustomerRequestData data) {
		return customerRepositoryJpa.save(modelMapper.map(data, CustomerDomain.class)).getIdCustomer();
	}

	@Override
	public Optional<CustomerDomain> findOneById(UUID idCustomer) {
		return customerRepositoryJpa.findById(idCustomer);
	}

	@Override
	public List<CustomerDomain> findAll() {
		return (List<CustomerDomain>) customerRepositoryJpa.findAll();
	}

	
}
