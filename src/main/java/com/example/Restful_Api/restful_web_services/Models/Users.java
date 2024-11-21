package com.example.Restful_Api.restful_web_services.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

//@JsonIgnoreProperties({"id", "birthDate"})
@Entity
public class Users {
	@NotNull
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
//	@JsonIgnore
	@Id
	@GeneratedValue
	private Integer id;
	@Past(message = "Birthdate should be in the past")
	private LocalDate birthDate;
	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private List<Posts> posts;

	protected Users() {
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

	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}
}