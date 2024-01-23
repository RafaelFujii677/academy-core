package br.com.academycore.adapters.ports.percistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.academycore.core.domains.CustomerDomain;

public interface CustomerRepositoryJpa extends CrudRepository<CustomerDomain, UUID>{

}
