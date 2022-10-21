package com.codegym.review;

import com.codegym.review.model.User;
import com.codegym.review.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ReviewApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Khi chương trình chạy
        // Insert vào csdl một user.
//        User user2 = new User();
//        user2.setUsername("admin2");
//        user2.setPassword(passwordEncoder.encode("123123"));
//        User user3 = new User();
//        user3.setUsername("admin3");
//        user3.setPassword(passwordEncoder.encode("123123"));
//        User user4 = new User();
//        user4.setUsername("admin4");
//        user4.setPassword(passwordEncoder.encode("123123"));
//        userRepository.save(user2);
//        userRepository.save(user3);
//        userRepository.save(user4);
    }

}
