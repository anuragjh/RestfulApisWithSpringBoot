package com.example.Restful_Api.restful_web_services.Repository;

import com.example.Restful_Api.restful_web_services.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
