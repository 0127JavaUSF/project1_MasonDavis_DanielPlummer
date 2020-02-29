package com.revature.model;

/*Daniel Plummer
 * Project_1
 * Reimb model class
 */

import java.sql.Date;

public class Reimb {

	private int reimbId;
	private String description, author, resolver, statusId, typeId;
	private double amount;
	private String submitted, resolved;

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	@Override
	public String toString() {
		return "Reimb [reimbId=" + reimbId + ", description=" + description + ", author=" + author + ", resolver="
				+ resolver + ", statusId=" + statusId + ", typeId=" + typeId + ", amount=" + amount + ", submitted="
				+ submitted + ", resolved=" + resolved + "]";
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public Reimb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimb(double amount, String description, String author, String statusId, String typeId) {
		super();
		this.author = author;
		this.statusId = statusId;
		this.typeId = typeId;
		this.description = description;
		this.amount = amount;
	}

	public Reimb(int reimbId, double amount, String submitted, String resolved, String description, String author, String resolver, String statusId, String typeId) {
		super();
		this.reimbId = reimbId;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
		this.description = description;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
	}
	
	public Reimb(int reimbId, String resolver, String statusId) {
		super();
		this.reimbId = reimbId;
		this.resolver = resolver;
		this.statusId = statusId;
	}

	

}
