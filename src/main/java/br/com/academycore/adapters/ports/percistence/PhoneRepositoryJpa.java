package br.com.academycore.adapters.ports.percistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.academycore.core.domains.PhoneDomain;

public interface PhoneRepositoryJpa extends CrudRepository<PhoneDomain, UUID>{

	PhoneDomain findByPhone(String phone);

	@Query(value = "select * from phones left join r_owner_phone using(id_phone) where id_owner = :idCustomer", nativeQuery = true)
	List<PhoneDomain> findAllByIdCustomer(UUID idCustomer);
}
