package com.example.Restful_Api.restful_web_services.SocialMediaControllers;
import com.example.Restful_Api.restful_web_services.Models.Users;
import com.example.Restful_Api.restful_web_services.SocialMediaServices.UserDataService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class SocialMediaController {
	private UserDataService service;

	public SocialMediaController(UserDataService service) {
		this.service = service;
	}

	@GetMapping(path = "/users")
	public List<Users> retrieveAllUsers(){
		return service.findAll();
	}
	@GetMapping(path = "/users/{id}")
	public Users retrieveUserById(@PathVariable int id){
		 Users user =service.findOne(id);
		 if (user == null){
			 throw new userNotFoundException("User not found");
		 }
		return user;
	}
	@PostMapping(path = "/users")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user){
         Users savedUser = service.save(user);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				 path("/{id}").
				 buildAndExpand(savedUser.getId()).
				 toUri();

		 return ResponseEntity.created(location).build();
	}
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id){
		service.deleteUser(id);
	}
}
