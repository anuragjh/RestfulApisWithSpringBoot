package com.example.Restful_Api.restful_web_services.Models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Users {
	@NotNull
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	private Integer id;
	@Past(message = "Birthdate should be in the past")
	private LocalDate birthDate;

	public Users() {
	}

	public Users(String name, int id, LocalDate birthDate) {
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Users{" +
				"name='" + name + '\'' +
				", id=" + id +
				", birthDate=" + birthDate +
				'}';
	}
}
