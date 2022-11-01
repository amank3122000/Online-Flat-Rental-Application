package com.cg.onlineflatrental.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TenantDTO {
	private int tenantId;
	@NotNull(message = "Tenant age is mandatory")
	@Min(value = 1, message = "Age should be more than 0")
	private int age;
	private FlatAddressDTO taddress;

	public TenantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TenantDTO(int tenantId, int age, FlatAddressDTO taddress) {
		super();
		this.tenantId = tenantId;
		this.age = age;
		this.taddress = taddress;
	}
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public FlatAddressDTO getTaddress() {
		return taddress;
	}
	public void setTaddress(FlatAddressDTO taddress) {
		this.taddress = taddress;
	}
	@Override
	public String toString() {
		return "TenantDTO [tenantId=" + tenantId + ", age=" + age + ", taddress="
				+ taddress + "]";
	}
}

