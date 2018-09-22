package com.ss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
	private long userId;
	private long profileId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String userPassword;
	private String contactNo;
	private String address;
	private String userName;
	private String passToken;
	private String link;
	private String resetPassword;
	private String role;


	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassToken() {
		return passToken;
	}

	public void setPassToken(String passToken) {
		this.passToken = passToken;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDTO(){}
	
	public UserDTO(long userId, long profileId, String firstName,
			String lastName, String emailId, String userPassword,
			String contactNo, String address, String userName,
			String passToken, String link, String resetPassword, String role) {
		super();
		this.userId = userId;
		this.profileId = profileId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userPassword = userPassword;
		this.contactNo = contactNo;
		this.address = address;
		this.userName = userName;
		this.passToken = passToken;
		this.link = link;
		this.resetPassword = resetPassword;
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", profileId=" + profileId
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", userPassword=" + userPassword
				+ ", contactNo=" + contactNo + ", address=" + address
				+ ", userName=" + userName + ", passToken=" + passToken
				+ ", link=" + link + ", resetPassword=" + resetPassword
				+ ", role=" + role + "]";
	}

	
}
