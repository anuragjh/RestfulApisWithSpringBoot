package com.example.Restful_Api.restful_web_services.SocialMediaControllers;
import com.example.Restful_Api.restful_web_services.Models.Posts;
import com.example.Restful_Api.restful_web_services.Models.Users;
import com.example.Restful_Api.restful_web_services.Repository.PostRepository;
import com.example.Restful_Api.restful_web_services.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class SocialMediaController {
	private UserRepository repository;
	private PostRepository postRepository;

	public SocialMediaController(UserRepository repository , PostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}

	@GetMapping(path = "/users")
	public List<Users> retrieveAllUsers(){
		return repository.findAll();
	}


	@GetMapping(path = "/users/{id}")
	public EntityModel<Users> retrieveUserById(@PathVariable int id){
		 Optional<Users> user =repository.findById(id);
		 if (user.isEmpty()){
			 throw new userNotFoundException("User not found");
		 }

		 EntityModel<Users> entity = EntityModel.of(user.get());
		 WebMvcLinkBuilder link = linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		entity.add(link.withRel("all-users"));
		 return entity;
	}
	@PostMapping(path = "/users")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user){
         Users savedUser = repository.save(user);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				 path("/{id}").
				 buildAndExpand(savedUser.getId()).
				 toUri();

		 return ResponseEntity.created(location).build();
	}
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id){
		repository.deleteById(id);
	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Posts> retrieveAllPosts(@PathVariable int id){
		Optional<Users> user = repository.findById(id);
		if (user.isEmpty()){
			throw new userNotFoundException("User not found");
		}
		return user.get().getPosts();
	}

	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Users> createPostForUser(@PathVariable int id,@Valid @RequestBody Posts posts){
		Optional<Users> user = repository.findById(id);
		if (user.isEmpty()){
			throw new userNotFoundException("User not found");
		}
		posts.setUsers(user.get());
		Posts savedPost= postRepository.save(posts);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").
				buildAndExpand(savedPost.getId()).
				toUri();

		return ResponseEntity.created(location).build();
	}
}
