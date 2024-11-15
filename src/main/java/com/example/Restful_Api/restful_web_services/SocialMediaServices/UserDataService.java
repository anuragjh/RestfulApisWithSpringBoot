package com.example.Restful_Api.restful_web_services.SocialMediaServices;

import com.example.Restful_Api.restful_web_services.Models.Users;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDataService {
	private static List<Users> usersList = new ArrayList<>();
	private static int count = 0 ;

	static {
		usersList.add(new Users("Aman Jha",++count, LocalDate.now().minusYears((6))));
		usersList.add(new Users("User_x",++count, LocalDate.now().minusYears((6))));
		usersList.add(new Users("User_y",++count, LocalDate.now().minusYears((6))));
		usersList.add(new Users("User_z",++count, LocalDate.now().minusYears((6))));
	}

	public List<Users> findAll(){
		return usersList;
	}

	public Users findOne(int id) {
		Predicate<? super Users> predicate = users -> users.getId() == id;
		return usersList.stream().filter(predicate).findFirst().orElse(null);
	}

	public Users save(Users user) {
		user.setId(++count);
		usersList.add(user);
		return user;
	}

	public void deleteUser(int id){
		Predicate<? super Users> predicate = users -> users.getId() == id;
		usersList.removeIf(predicate);
	}

}
