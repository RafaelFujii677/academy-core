package br.com.academycore.core.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.academycore.core.domains.PhoneDomain;

public interface PhoneRepository {

	PhoneDomain save(PhoneDomain phonesDomain);

	Optional<PhoneDomain> findOneById(UUID idPhone);
	Optional<PhoneDomain> findOneByPhone(String phone);

	List<PhoneDomain> findAllByIdCustomer(UUID idCustomer);
}
