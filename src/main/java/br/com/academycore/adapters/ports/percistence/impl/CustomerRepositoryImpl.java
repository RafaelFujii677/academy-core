package br.com.academycore.adapters.ports.percistence.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.academycore.adapters.ports.percistence.CustomerRepositoryJpa;
import br.com.academycore.core.domains.CustomerDomain;
import br.com.academycore.core.repositories.CustomerRepository;

public class CustomerRepositoryImpl implements Serializable, CustomerRepository {
	private static final long serialVersionUID = 1L;

	private final CustomerRepositoryJpa customerRepositoryJpa;

	public CustomerRepositoryImpl(CustomerRepositoryJpa customerRepositoryJpa) {
		this.customerRepositoryJpa = customerRepositoryJpa;
	}

	@Override
	public UUID save(CustomerDomain customerDomain) {
		return customerRepositoryJpa.save(customerDomain).getIdCustomer();
	}

	@Override
	public void delete(UUID idCustomer) {
		customerRepositoryJpa.deleteById(idCustomer);
	}

	@Override
	public Optional<CustomerDomain> findOneById(UUID idCustomer) {
		return customerRepositoryJpa.findById(idCustomer);
	}

	@Override
	public List<CustomerDomain> findAllByPhone(String phone) {
		return customerRepositoryJpa.findByPhone(phone);
	}

	@Override
	public List<CustomerDomain> findAll() {
		return (List<CustomerDomain>) customerRepositoryJpa.findAll();
	}

	
}
