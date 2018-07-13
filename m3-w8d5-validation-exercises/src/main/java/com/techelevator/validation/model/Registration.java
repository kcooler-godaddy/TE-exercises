package com.techelevator.validation.model;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Registration {
	
	@NotBlank(message="Required")
	@Size(max=20, message="Cannot be more than 20 charactors")
	private String firstName;
	
	@NotBlank(message="Required")
	@Size(max=20, message="Cannot be more than 20 characters")
	private String lastName;
	
	@NotBlank(message="Required")
	@Email(message="Must be a valid email address")
	private String email;
	
	@NotBlank(message="Required")
	private String confirmEmail;
	
	@NotBlank(message="Required")
	@Size(min=8, message="Cannot be less than 8 characters")
	private String password;
	
	@NotBlank(message="Required")
	private String confirmPassword;
	
	@NotBlank(message="Required")
	@Pattern(regexp="^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$", message="Use correct date format")
	private String birthday;
	
	@Min(value=1, message="Must enter at least 1")
	@Max(value=10, message="Cannot enter more than 10")
	private int numberOfTickets;
	
	private boolean emailMatch;
	@AssertTrue(message="Emails must match")
	public boolean isEmailMatch() {
		if(email != null) {
			return email.equals(confirmEmail);
		}
		return false;
	}
	
	private boolean passwordMatch;
	@AssertTrue(message="Passwords must match")
	public boolean isPasswordMatch() {
		if(password != null) {
			return password.equals(confirmPassword);
		}
		return false;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	
	public void setEmailMatch(boolean emailMatch) {
		this.emailMatch = emailMatch;
	}
	public void setPasswordMatch(boolean passwordMatch) {
		this.passwordMatch = passwordMatch;
	}


	public String getConfirmEmail() {
		return confirmEmail;
	}


	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
