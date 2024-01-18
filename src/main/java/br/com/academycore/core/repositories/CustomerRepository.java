package br.com.academycore.core.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.academycore.core.domains.CustomerDomain;

public interface CustomerRepository extends CrudRepository<CustomerDomain, UUID>{

}
