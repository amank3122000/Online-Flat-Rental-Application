package com.cg.onlineflatrental.entity;
import javax.persistence.Entity;   
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tenant")
public class Tenant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tenantId;
	private String tenantName;
	private int age;
	@OneToOne
	private FlatAddress taddress;
	
	public Tenant() {
		super();
	}
	public Tenant(int tenantId, String tenantName, int age, FlatAddress taddress) {
		super();
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.age = age;
		this.taddress = taddress;
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
	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", tenantName=" + tenantName + ", age=" + age + ", taddress=" + taddress
				+ "]";
	}
}
