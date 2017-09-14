package src.com.secretd.web.entity;

import java.sql.Time;

public class Hospital {
	private String number;
	private String subject;
	private String name;
	private String address;
	private String phoneNumber;
	private Time openingHours;
	private String homepage;
	private String character;
	private String score;
	private String managerId;
	
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}


	public Hospital(String number, String subject, String name, String address, String phoneNumber, Time openingHours,
			String homepage, String character, String score, String managerId) {
		super();
		this.number = number;
		this.subject = subject;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.openingHours = openingHours;
		this.homepage = homepage;
		this.character = character;
		this.score = score;
		this.managerId = managerId;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Time getOpeningHours() {
		return openingHours;
	}


	public void setOpeningHours(Time openingHours) {
		this.openingHours = openingHours;
	}


	public String getHomepage() {
		return homepage;
	}


	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}


	public String getCharacter() {
		return character;
	}


	public void setCharacter(String character) {
		this.character = character;
	}


	public String getScore() {
		return score;
	}


	public void setScore(String score) {
		this.score = score;
	}


	public String getManagerId() {
		return managerId;
	}


	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	
}
