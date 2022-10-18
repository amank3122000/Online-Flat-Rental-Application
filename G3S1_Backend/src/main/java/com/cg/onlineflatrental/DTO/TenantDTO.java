package com.cg.onlineflatrental.DTO;

public class TenantDTO {
	private int tenantId;
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

