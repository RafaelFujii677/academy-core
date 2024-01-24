package br.com.academycore.core.usercases;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.academycore.AcademyCoreApplication;
import br.com.academycore.core.domains.CustomerDomain;
import br.com.academycore.core.repositories.CustomerRepository;
import br.com.academycore.core.usecases.CreateCustomer;
import br.com.academycore.core.usecases.DeleteCustomer;
import br.com.academycore.core.usecases.requests.CreateCustomerRequestData;

@ActiveProfiles("test")
@SpringBootTest(classes = AcademyCoreApplication.class)
public class CustomerTest {

	private final CreateCustomer createCustomer;
	private final DeleteCustomer deleteCustomer;
	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerTest(CreateCustomer createCustomer, DeleteCustomer deleteCustomer, CustomerRepository customerRepository) {
		this.createCustomer = createCustomer;
		this.deleteCustomer = deleteCustomer;
		this.customerRepository = customerRepository;
	}

	@Test
	@DisplayName("Should save correctly customer")
	public void performOnlySaveSuccess() throws Exception {
		CreateCustomerRequestData data = new CreateCustomerRequestData("Juninho", LocalDate.of(2000, 1, 1));
		UUID idCustomer = createCustomer.perform(data);

		Assert.assertNotNull(idCustomer);
	}

	@Test
	@DisplayName("Should save and delete correctly customer")
	public void performCrudSuccess() throws Exception {
		CreateCustomerRequestData data = new CreateCustomerRequestData("Rafael", LocalDate.of(2000, 1, 1));
		UUID idCustomer = createCustomer.perform(data);

		Assert.assertNotNull(idCustomer);

		deleteCustomer.perform(idCustomer);
		Optional<CustomerDomain> customer = customerRepository.findOneById(idCustomer);

		if(customer.isPresent())
			Assert.fail("Customer shouldn't exist");
		else
			Assert.assertTrue(true);
	}

	@Test
	@DisplayName("Should save incorrectly customer without name")
	public void performOnlySaveFailureName() throws Exception {
		CreateCustomerRequestData data = new CreateCustomerRequestData("", LocalDate.of(2000, 1, 1));
		try {
			createCustomer.perform(data);
			Assert.fail("Customer without name shouldn't be saved.");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}

	}
}
