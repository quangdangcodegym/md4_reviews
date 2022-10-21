package com.codegym.review.services;

import com.codegym.review.model.CustomUserDetails;
import com.codegym.review.model.User;
import com.codegym.review.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> list = null;
        if(user.getUsername().equals("admin2")){
            list = Arrays.asList(new SimpleGrantedAuthority("USER"));
        }
        if(user.getUsername().equals("admin3")){
            list = Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
        }
        if(user.getUsername().equals("admin4")){
            list = Arrays.asList(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("ADMIN"));
        }
        return new CustomUserDetails(user, list);
    }


}