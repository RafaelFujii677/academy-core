package br.com.academycore.core.domains;

import java.io.Serializable;
import java.util.UUID;

public class PhonesDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	private UUID idPhone;
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
