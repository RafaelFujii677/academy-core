package br.com.academycore.core.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.academycore.core.domains.CustomerDomain;
import br.com.academycore.core.usecases.requests.CreateCustomerRequestData;

public interface CustomerRepository {

	UUID save(CreateCustomerRequestData data);

	Optional<CustomerDomain> findOneById(UUID idCustomer);

	List<CustomerDomain> findAll();
}
