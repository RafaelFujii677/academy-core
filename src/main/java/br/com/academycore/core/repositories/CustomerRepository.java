package br.com.academycore.core.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.academycore.core.domains.CustomerDomain;

public interface CustomerRepository {

	UUID save(CustomerDomain customerDomain);
	void delete(UUID idCustomer);

	Optional<CustomerDomain> findOneById(UUID idCustomer);

	List<CustomerDomain> findAll();
}
