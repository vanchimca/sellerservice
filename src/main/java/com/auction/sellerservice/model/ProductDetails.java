package com.auction.sellerservice.model;

import java.math.BigInteger;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "productdetails")
public class ProductDetails {

	@Id
    private String _id;
	
	@NotBlank(message = "Product name is mandatory")
	@Size(min=5, max=30, message= "Product name length should be between 5 to 30")
	String productName;
	
	String shortDesc;	
	String detailedDesc;	
	String Category;
	
	@NumberFormat
	Double startingPrice;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	Date bidEndDate;
	
	@NotBlank(message = "Firstname is mandatory")
	@Size(min=5, max=30, message= "Fistname length should be between 5 to 30")
	String sellerFirstName;
	
	@NotBlank(message = "Lastname is mandatory")
	@Size(min=5, max=30, message= "Lastname length should be between 5 to 30")
	String sellerLastName;
	
	String address;
	String city;
	String state;
	Integer pin;
	Integer phone;
	
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	String mail;
	
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the shortDesc
	 */
	public String getShortDesc() {
		return shortDesc;
	}
	/**
	 * @param shortDesc the shortDesc to set
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	/**
	 * @return the detailedDesc
	 */
	public String getDetailedDesc() {
		return detailedDesc;
	}
	/**
	 * @param detailedDesc the detailedDesc to set
	 */
	public void setDetailedDesc(String detailedDesc) {
		this.detailedDesc = detailedDesc;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return Category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		Category = category;
	}
	/**
	 * @return the startingPrice
	 */
	public Double getStartingPrice() {
		return startingPrice;
	}
	/**
	 * @param startingPrice the startingPrice to set
	 */
	public void setStartingPrice(Double startingPrice) {
		this.startingPrice = startingPrice;
	}
	/**
	 * @return the bidEndDate
	 */
	public Date getBidEndDate() {
		return bidEndDate;
	}
	/**
	 * @param bidEndDate the bidEndDate to set
	 */
	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}
	/**
	 * @return the sellerFirstName
	 */
	public String getSellerFirstName() {
		return sellerFirstName;
	}
	/**
	 * @param sellerFirstName the sellerFirstName to set
	 */
	public void setSellerFirstName(String sellerFirstName) {
		this.sellerFirstName = sellerFirstName;
	}
	/**
	 * @return the sellerLastName
	 */
	public String getSellerLastName() {
		return sellerLastName;
	}
	/**
	 * @param sellerLastName the sellerLastName to set
	 */
	public void setSellerLastName(String sellerLastName) {
		this.sellerLastName = sellerLastName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pin
	 */
	public Integer getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	/**
	 * @return the phone
	 */
	public Integer getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
	
	