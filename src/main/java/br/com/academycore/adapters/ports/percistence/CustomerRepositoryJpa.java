package br.com.academycore.adapters.ports.percistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.academycore.core.domains.CustomerDomain;

public interface CustomerRepositoryJpa extends CrudRepository<CustomerDomain, UUID>{

	@Query(value = "select * from customer where id_customer = (select id_owner from phones left join r_owner_phone using(id_phone) where phone = :phone)", nativeQuery = true)
	List<CustomerDomain> findByPhone(String phone);
}
