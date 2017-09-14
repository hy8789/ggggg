package src.com.secretd.web.entity;

import java.awt.Image;
import java.sql.Blob;

public class Disease {
	private String number;
	private String classCode;
	private String name;
	private String explanation;
	private Blob picture;
	private String managerI;
	private int countCmt;
	private String category;	
	

	public Disease() {
		// TODO Auto-generated constructor stub
	}

	public Disease(String number, String classCode, String name, String explanation, Blob picture, String managerI) {
		super();
		this.number = number;
		this.classCode = classCode;
		this.name = name;
		this.explanation = explanation;
		this.picture = picture;
		this.managerI = managerI;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob blob) {
		this.picture = blob;
	}

	public String getManagerI() {
		return managerI;
	}

	public void setManagerI(String managerI) {
		this.managerI = managerI;
	}
	public int getCountCmt() {
		return countCmt;
	}

	public void setCountCmt(int countCmt) {
		this.countCmt = countCmt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
}