package br.com.academycore.core.usecases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import br.com.academycore.core.domains.CustomerDomain;
import br.com.academycore.core.domains.PhoneDomain;
import br.com.academycore.core.repositories.CustomerRepository;
import br.com.academycore.core.repositories.PhoneRepository;
import br.com.academycore.core.usecases.requests.CreatePhoneRequestData;
import jakarta.transaction.Transactional;

public class CreateAndSetOwnerPhone implements Serializable{
	private static final long serialVersionUID = 1L;

	private final PhoneRepository phoneRepository;
	private final CustomerRepository customerRepository;

	public CreateAndSetOwnerPhone(PhoneRepository phoneRepository, CustomerRepository customerRepository) {
		this.phoneRepository = phoneRepository;
		this.customerRepository = customerRepository;
	}

	@Transactional
	public UUID perform(CreatePhoneRequestData data) throws Exception {
		if(data == null) throw new Exception("Data to create phone is null");
		if(data.getIdOwner() == null) throw new Exception("Owner id is required to create new phone");
		if(!StringUtils.isNotBlank(data.getPhone())) throw new Exception("Phone can't be null");

		phoneRepository.findOneByPhone(data.getPhone());

		Optional<CustomerDomain> customer = customerRepository.findOneById(data.getIdOwner());
		if(customer.isPresent()) {
			PhoneDomain phoneSaved = phoneRepository.save(new PhoneDomain(data.getPhone()));

			List<PhoneDomain> phones = customer.get().getPhonesCustomer();
			if(phones == null) phones = new ArrayList<>();
			phones.add(phoneSaved);

			customerRepository.save(customer.get());

			return phoneSaved.getIdPhone();
		}

		// TODO add too employeed

		throw new Exception("Owner not found");
	}
}
