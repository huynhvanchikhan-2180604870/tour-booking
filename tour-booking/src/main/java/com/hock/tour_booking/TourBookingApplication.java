package com.hock.tour_booking;

import com.hock.tour_booking.entity.Role;
import com.hock.tour_booking.entity.User;
import com.hock.tour_booking.security.auth_serivce.UserSerivce;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
public class TourBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourBookingApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner(UserSerivce userSerivce){
		return args -> {
//			userSerivce.saveRole(new Role(UUID.randomUUID(), "ROLE_USER"));
//			userSerivce.saveRole(new Role(UUID.randomUUID(), "ROLE_MANAGER"));
//			userSerivce.saveRole(new Role(UUID.randomUUID(), "ROLE_ADMIN"));
//			userSerivce.saveRole(new Role(UUID.randomUUID(), "ROLE_SUPER_ADMIN"));



//			userSerivce.saveUser(
//					new User(
//							UUID.randomUUID(),
//							"HOCK",
//							"admin@gmail.com",
//							"admin",
//							"09718000341",
//							"HCM",
//							true,
//							LocalDateTime.now().minusDays((int) (Math.random() * 365)),
//							LocalDateTime.now().minusDays((int) (Math.random() * 365)),
//							new HashSet<>()
//					)
//			);
//
//			userSerivce.saveUser(
//					new User(
//							UUID.randomUUID(),
//							"KHAN",
//							"khan@gmail.com",
//							"admin",
//							"09718000341",
//							"HCM",
//							true,
//							LocalDateTime.now().minusDays((int) (Math.random() * 365)),
//							LocalDateTime.now().minusDays((int) (Math.random() * 365)),
//							new HashSet<>()
//					)
//			);

//			userSerivce.addRoleToUser("admin@gmail.com","ROLE_USER");
//			userSerivce.addRoleToUser("admin@gmail.com","ROLE_MANAGER");
//			userSerivce.addRoleToUser("khan@gmail.com","ROLE_ADMIN");
//			userSerivce.addRoleToUser("khan@gmail.com","ROLE_SUPER_ADMIN");
		};
	}
}
