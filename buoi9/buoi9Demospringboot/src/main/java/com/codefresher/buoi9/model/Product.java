package com.codefresher.buoi9.model;

public class Product {
	private int id;
	private String name;
	private String dateCreate;
	private String nhaSanXuat;

	public Product(int id, String name, String dateCreate, String nhaSanXuat) {
		super();
		this.id = id;
		this.name = name;
		this.dateCreate = dateCreate;
		this.nhaSanXuat = nhaSanXuat;
	}

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

}
