package banking.app.Dto;

public class AddressDto {

private	int addId;
private	String homeNo;
private	String areaTwon;
private	String city;
private	String state;
private	String zipCode;

public AddressDto() {
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
