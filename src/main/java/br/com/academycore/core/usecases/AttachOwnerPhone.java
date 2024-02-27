package br.com.academycore.core.usecases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import br.com.academycore.core.domains.CustomerDomain;
import br.com.academycore.core.domains.PhoneDomain;
import br.com.academycore.core.repositories.CustomerRepository;
import br.com.academycore.core.repositories.PhoneRepository;
import br.com.academycore.core.usecases.requests.CreatePhoneRequestData;
import jakarta.transaction.Transactional;

public class AttachOwnerPhone implements Serializable{
	private static final long serialVersionUID = 1L;

	private final PhoneRepository phoneRepository;
	private final CustomerRepository customerRepository;

	public AttachOwnerPhone(PhoneRepository phoneRepository, CustomerRepository customerRepository) {
		this.phoneRepository = phoneRepository;
		this.customerRepository = customerRepository;
	}

	@Transactional
	public void perform(CreatePhoneRequestData data) throws Exception {
		if(data == null) throw new Exception("Data to attach phone can't null");
		if(data.getIdOwner() == null) throw new Exception("Owner id can't be null");
		if(!StringUtils.isNotBlank(data.getPhone())) throw new Exception("Phone number can't be null");

		Optional<PhoneDomain> phone = phoneRepository.findOneByPhone(data.getPhone());
		if(!phone.isPresent()) throw new Exception("Phone not found");

		Optional<CustomerDomain> customer = customerRepository.findOneById(data.getIdOwner());
		if(customer.isPresent()) {
			List<CustomerDomain> customersPhone = customerRepository.findAllByPhone(data.getPhone());

			if(!customersPhone.isEmpty())
				if(customersPhone.contains(customer.get()))
					throw new Exception("This owner already attached this phone");

			List<PhoneDomain> phones = customer.get().getPhonesCustomer();
			if(phones == null) phones = new ArrayList<>();
			phones.add(phone.get());
			customerRepository.save(customer.get());
		}

		// TODO make too for employed

		throw new Exception("Owner not found");
	}

}
