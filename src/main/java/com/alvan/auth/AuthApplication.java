package com.alvan.auth;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.alvan.auth.entity.AppUser;
import com.alvan.auth.entity.Role;
import com.alvan.auth.service.AppUserService;

@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// @Bean
	// CommandLineRunner run(AppUserService appUserService){
	// 	return args ->{
	// 		appUserService.saveRole(new Role(null, "ROLE_USER"));
	// 		appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
	// 		appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
	// 		appUserService.saveRole(new Role(null, "ROLE_SUPERADMIN"));

	// 		appUserService.saveUser(new AppUser(null,"Alvan", "alvan@gmail.com", "123456",new ArrayList<>()));
	// 		appUserService.saveUser(new AppUser(null,"John", "john@gmail.com" ,"123456",new ArrayList<>()));
	// 		appUserService.saveUser(new AppUser(null,"Mike", "mike@gmail.com" ,"123456",new ArrayList<>()));
	// 		appUserService.saveUser(new AppUser(null,"Caleb", "caleb@gmail.com" ,"123456",new ArrayList<>()));

	// 		appUserService.addRoleToAppUser("john@gmail.com", "ROLE_USER");
	// 		appUserService.addRoleToAppUser("john@gmail.com", "ROLE_MANAGER");
	// 		appUserService.addRoleToAppUser("mike@gmail.com", "ROLE_USER");
	// 		appUserService.addRoleToAppUser("caleb@gmail.com", "ROLE_MANAGER");
	// 		appUserService.addRoleToAppUser("caleb@gmail.com", "ROLE_USER");
	// 		appUserService.addRoleToAppUser("alvan@gmail.com", "ROLE_USER");
	// 		appUserService.addRoleToAppUser("alvan@gmail.com", "ROLE_SUPERADMIN");
	// 		appUserService.addRoleToAppUser("alvan@gmail.com", "ROLE_ADMIN");
			
	// 	};
	// }
}
