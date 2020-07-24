package edu.mum.main;


import edu.mum.domain.User;
import edu.mum.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		UserService userService = (UserService) ctx.getBean("userServiceImpl");
		List<User> users = userService.findAll();
		System.out.println("User count: " + users.size());

		User user = new User();
		user.setFirstName("Moha");
		user.setLastName("Aman");
		user.setEmail("mam@miu.edu");
		user.setLastLogin(new Date());
		user.setAdmin(true);

		userService.save(user);
		System.out.println("User inserted! ");
		users = userService.findAll();
		User userByEmail = userService.findByEmail("mam@miu.edu");
		System.out.println("*********** User ********** ");
		System.out.println("User Name: " + userByEmail.getFirstName() + " " + userByEmail.getLastName());
		
		System.out.println(" Merging user");
		user.setEmail("ma@mum.edu");
		userService.merge(user);
		user.setEmail("mmmma@mum.edu");

		try {
			userService.merge(user);
		} catch (Exception e) {
			System.out.println("You are trying to update object with unmanaged version");
		}
		
	}
}