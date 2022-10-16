package com.cg.onlineflatrental.entity;
import java.util.List; 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
//import javax.persistence.Table;


@Entity
public class Landlord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int landlordId;
	private String landlordName;
	private int landlordAge;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="flatId")
	private List<Flat> flatList;
  
	public Landlord() {}
	public Landlord( String landlordName, int landlordAge, List<Flat> flatList) {
		super();
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
		this.flatList = flatList;
	}
	public Integer getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(Integer landlordId) {
		this.landlordId = landlordId;
	}
	public String getLandlordName() {
		return landlordName;
	}
	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}
	public int getLandlordAge() {
		return landlordAge;
	}
	public void setLandlordAge(int landlordAge) {
		this.landlordAge = landlordAge;
	}
	public List<Flat> getFlatList() { 
		  return flatList; 
	} 
	public void setFlatList(List<Flat> flatList) { 
		  this.flatList = flatList;
	}
	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+ ", flatList=" + flatList + "]";
	}
}
