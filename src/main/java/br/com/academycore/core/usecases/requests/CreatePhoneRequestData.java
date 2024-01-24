package br.com.academycore.core.usecases.requests;

import java.io.Serializable;
import java.util.UUID;

public class CreatePhoneRequestData implements Serializable{
	private static final long serialVersionUID = 1L;

	private String phone;
	private UUID idOwner;

	public CreatePhoneRequestData(String phone, UUID idOwner) {
		super();
		this.phone = phone;
		this.idOwner = idOwner;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UUID getIdOwner() {
		return idOwner;
	}
	public void setIdOwner(UUID idOwner) {
		this.idOwner = idOwner;
	}
}
