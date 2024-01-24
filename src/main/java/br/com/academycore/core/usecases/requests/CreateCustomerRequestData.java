package br.com.academycore.core.usecases.requests;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import br.com.academycore.core.domains.PhoneDomain;

public class CreateCustomerRequestData implements Serializable{
	private static final long serialVersionUID = 1L;

	private UUID idCustomer;
	private String nameCustomer;
	private LocalDate birthdateCustomer;
	private List<PhoneDomain> phonesCustomer;

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
	public List<PhoneDomain> getPhonesCustomer() {
		return phonesCustomer;
	}
	public void setPhonesCustomer(List<PhoneDomain> phonesCustomer) {
		this.phonesCustomer = phonesCustomer;
	}
}
