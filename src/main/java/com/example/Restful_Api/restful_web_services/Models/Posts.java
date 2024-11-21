package com.example.Restful_Api.restful_web_services.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Posts {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 2, message = "Description should have atleast 2 characters")
	private String description;
	@ManyToOne(fetch =  FetchType.LAZY)
	@JsonIgnore
	private Users users;


	protected Posts() {
	}

	public Posts(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}
