package cbk.attributes.com;

public class ContactBook {
	String name;
	String phoneNumber;
	String email;
	String simcardType;


public ContactBook(String Name, String phoneNumber, String Nickname,String email, String simCardType) {
	this.name = Name;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.simcardType = simCardType;
}
public String getFullname(){
	return name;
}
public void setFullname(String fullName){
	this.name = fullName;
}
public String getNumber(){
	return phoneNumber;
}
public void setNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getEmail(){
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getsimCardType() {
	return simcardType;
}
public void setsimCardType(String simCardType) {
	this.simcardType = simCardType;
}
}
