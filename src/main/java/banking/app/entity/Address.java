package banking.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	int addId;
	String homeNo;
	String areaTwon;
	String city;
	String state;
	String zipCode;
	public Address(int addId, String homeNo, String areaTwon, String city, String state, String zipCode) {
		super();
		this.addId = addId;
		this.homeNo = homeNo;
		this.areaTwon = areaTwon;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}
	public String getAreaTwon() {
		return areaTwon;
	}
	public void setAreaTwon(String areaTwon) {
		this.areaTwon = areaTwon;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	

}
