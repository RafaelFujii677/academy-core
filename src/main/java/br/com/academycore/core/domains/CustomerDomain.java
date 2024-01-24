package br.com.academycore.core.domains;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID idCustomer;

	@Column(length = 60, nullable = false)
	private String nameCustomer;

	private LocalDate birthdateCustomer;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "r_owner_phone", joinColumns = @JoinColumn(name = "idOwner", referencedColumnName = "idCustomer"), inverseJoinColumns = @JoinColumn(name = "idPhone"))
	private List<PhoneDomain> phonesCustomer;

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
	public List<PhoneDomain> getPhonesCustomer() {
		return phonesCustomer;
	}
	public void setPhonesCustomer(List<PhoneDomain> phonesCustomer) {
		this.phonesCustomer = phonesCustomer;
	}
}
