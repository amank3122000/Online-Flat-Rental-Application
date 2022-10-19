package com.cg.onlineflatrental.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;   
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Tenant {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int tenantId;
	@NotNull(message = "Tenant age is mandatory")
	@Min(value = 1, message = "Age should be more than 0")
	private int age;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "houseNo", unique = true)
	private FlatAddress taddress;
	
	public Tenant(int tenantId, int age, FlatAddress taddress) {
		super();
		this.tenantId = tenantId;
		this.age = age;
		this.taddress = taddress;
	}
	
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlatAddress getTaddress() {
		return taddress;
	}
	public void setTaddress(FlatAddress taddress) {
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
	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", age=" + age + ", taddress=" + taddress
				+ "]";
	}
	
}
