package br.com.academycore.core.usercases;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.academycore.AcademyCoreApplication;
import br.com.academycore.core.usecases.CreateCustomer;
import br.com.academycore.core.usecases.requests.CreateCustomerRequestData;

@ActiveProfiles("test")
@SpringBootTest(classes = AcademyCoreApplication.class)
public class CreateCustomerTest {

	@Autowired
	private CreateCustomer createCustomer;

	@Test
	@DisplayName("Should show a correctly saved customer")
	public void performSuccess() throws Exception {
		CreateCustomerRequestData data = new CreateCustomerRequestData("João", LocalDate.of(2000, 1, 1));
		CreateCustomerRequestData dataSaved = createCustomer.perform(data);

		Assert.assertNotNull(dataSaved);
		Assert.assertEquals(data.getNameCustomer(), dataSaved.getNameCustomer());
		Assert.assertEquals(data.getBirthdateCustomer(), dataSaved.getBirthdateCustomer());
	}
}
