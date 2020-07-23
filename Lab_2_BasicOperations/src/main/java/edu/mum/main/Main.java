package edu.mum.main;


import edu.mum.domain.User;
import edu.mum.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("context/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        List<User> users =  userService.findAll();
       // List<User> users =new  ArrayList<User>();
        System.out.println("User count: " + users.size());

        User user = new User();
        user.setFirstName("Moha");
        user.setLastName("Aman");
        user.setId(611137l);
        user.setEmail("mam@miu.edu");
        user.setLastLogin(new Date());
        user.setRating(5);
        user.setAdmin(false);

        userService.save(user);
        System.out.println("User inserted! ");
        users = userService.findAll();
        User userByEmail = userService.findByEmail("mam@miu.edu");
        System.out.println("*********** User ********** ");
        System.out.println("User Name: " + userByEmail.getFirstName() + " " + userByEmail.getLastName());
    }

}