package br.com.academycore.adapters.ports.percistence.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.academycore.adapters.ports.percistence.PhoneRepositoryJpa;
import br.com.academycore.core.domains.PhoneDomain;
import br.com.academycore.core.repositories.PhoneRepository;

public class PhoneRepositoryImpl implements Serializable, PhoneRepository {
	private static final long serialVersionUID = 1L;

	private final PhoneRepositoryJpa phoneRepositoryJpa;

	public PhoneRepositoryImpl(PhoneRepositoryJpa phoneRepositoryJpa) {
		this.phoneRepositoryJpa = phoneRepositoryJpa;
	}

	@Override
	public PhoneDomain save(PhoneDomain phonesDomain) {
		return phoneRepositoryJpa.save(phonesDomain);
	}

	@Override
	public Optional<PhoneDomain> findOneById(UUID idPhone) {
		return phoneRepositoryJpa.findById(idPhone);
	}

	@Override
	public Optional<PhoneDomain> findOneByPhone(String phone) {
		PhoneDomain phoneByPhone = phoneRepositoryJpa.findByPhone(phone);
		if(phoneByPhone != null)
			return Optional.of(phoneByPhone);
		else
			return Optional.empty();
	}

	@Override
	public List<PhoneDomain> findAllByIdCustomer(UUID idCustomer) {
		return phoneRepositoryJpa.findAllByIdCustomer(idCustomer);
	}

}
