package com.example.Restful_Api.restful_web_services.Repository;

import com.example.Restful_Api.restful_web_services.Models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Integer> {
}
