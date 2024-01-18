package br.com.academycore.core.usecases.requests;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import br.com.academycore.core.domains.CustomerDomain;
import br.com.academycore.core.domains.PhonesDomain;

public class CreateCustomerRequestData implements Serializable{
	private static final long serialVersionUID = 1L;

	private UUID idCustomer;
	private String nameCustomer;
	private LocalDate birthdateCustomer;
	private List<PhonesDomain> phonesCustomer;

	public static CreateCustomerRequestData toRequestData(CustomerDomain customerDomain) {
		CreateCustomerRequestData createCustomerRequestData = new CreateCustomerRequestData(customerDomain.getNameCustomer());
		BeanUtils.copyProperties(customerDomain, createCustomerRequestData);
		return createCustomerRequestData;
	}
	
	public static CustomerDomain fromRequestData(CreateCustomerRequestData createCustomerRequestData) {
		CustomerDomain customerDomain = new CustomerDomain();
		BeanUtils.copyProperties(createCustomerRequestData, customerDomain);
		return customerDomain;
	}

	public CreateCustomerRequestData(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public CreateCustomerRequestData(String nameCustomer, LocalDate birthdateCustomer) {
		this.nameCustomer = nameCustomer;
		this.birthdateCustomer = birthdateCustomer;
	}

	
	public UUID getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(UUID idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public LocalDate getBirthdateCustomer() {
		return birthdateCustomer;
	}
	public void setBirthdateCustomer(LocalDate birthdateCustomer) {
		this.birthdateCustomer = birthdateCustomer;
	}
	public List<PhonesDomain> getPhonesCustomer() {
		return phonesCustomer;
	}
	public void setPhonesCustomer(List<PhonesDomain> phonesCustomer) {
		this.phonesCustomer = phonesCustomer;
	}
}
