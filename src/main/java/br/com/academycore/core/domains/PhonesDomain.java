package br.com.academycore.core.domains;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "phones")
public class PhonesDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID idPhone;
	@Column(unique = true, nullable = false)
	private String phone;

	public PhonesDomain() { super(); }

	public UUID getIdPhone() {
		return idPhone;
	}
	public void setIdPhone(UUID idPhone) {
		this.idPhone = idPhone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
