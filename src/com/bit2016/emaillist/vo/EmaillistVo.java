package com.bit2016.emaillist.vo;

public class EmaillistVo {

	private Long no;
	private String lastName;
	private String firstName;
	private String email;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmaillistVo [no=" + no + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ "]";
	}
}
