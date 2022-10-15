package com.cg.onlineflatrental.DTO;

import com.cg.onlineflatrental.entity.FlatAddress;

public class TenantDTO {
	private int tenantId;
	private String tenantName;
	private int age;
	private FlatAddress taddress;
	/**
	 * 
	 */
	public TenantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param tenantId
	 * @param tenantName
	 * @param age
	 * @param taddress
	 */
	public TenantDTO(int tenantId, String tenantName, int age, FlatAddress taddress) {
		super();
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.age = age;
		this.taddress = taddress;
	}
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public FlatAddress getTaddress() {
		return taddress;
	}
	public void setTaddress(FlatAddress taddress) {
		this.taddress = taddress;
	}
	@Override
	public String toString() {
		return "TenantDTO [tenantId=" + tenantId + ", tenantName=" + tenantName + ", age=" + age + ", taddress="
				+ taddress + "]";
	}
}
