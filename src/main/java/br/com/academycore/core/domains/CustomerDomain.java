package br.com.academycore.core.domains;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class CustomerDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	private UUID idCustomer;
	private String nameCustomer;
	private LocalDate birthdateCustomer;
	private List<PhonesDomain> phonesCustomer;

	public CustomerDomain() { super(); }

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
