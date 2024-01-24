package br.com.academycore.core.usercases;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.academycore.AcademyCoreApplication;
import br.com.academycore.core.domains.PhoneDomain;
import br.com.academycore.core.repositories.PhoneRepository;
import br.com.academycore.core.usecases.CreateAndSetOwnerPhone;
import br.com.academycore.core.usecases.requests.CreatePhoneRequestData;

@ActiveProfiles("test")
@SpringBootTest(classes = AcademyCoreApplication.class)
public class PhoneTest {

	private final CreateAndSetOwnerPhone createAndSetOwnerPhone;
	private final PhoneRepository phoneRepository;

	@Autowired
	public PhoneTest(CreateAndSetOwnerPhone createAndSetOwnerPhone, PhoneRepository phoneRepository) {
		this.createAndSetOwnerPhone = createAndSetOwnerPhone;
		this.phoneRepository = phoneRepository;
	}

	@Test
	@DisplayName("Should save and set owner a new phone")
	public void performSuccessSavePhone() {
		try {
			CreatePhoneRequestData createPhoneRequestData = new CreatePhoneRequestData("21945874587", UUID.fromString("ab080149-dcdf-4b6c-b5d3-d4041b523367"));
			UUID phoneSavedId = createAndSetOwnerPhone.perform(createPhoneRequestData);

			Optional<PhoneDomain> phoneSaved = phoneRepository.findOneById(phoneSavedId);
			if(phoneSaved.isPresent())
				Assert.assertTrue(true);
			else
				Assert.fail("Phone saved not found");

			List<PhoneDomain> phones = phoneRepository.findAllByIdCustomer(createPhoneRequestData.getIdOwner());
			if(phones.isEmpty())
				Assert.fail("Phone saved haven't relationsip by customer");
			else {
				Optional<PhoneDomain> phoneFiltred = phones.stream().filter(item -> item.getPhone().equals(createPhoneRequestData.getPhone())).findFirst();
				if(phoneFiltred.isPresent())
					Assert.assertTrue(true);
				else
					Assert.fail("Phone saved haven't relationsip by customer");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error on save correctly test");
		}
		
	}
}
