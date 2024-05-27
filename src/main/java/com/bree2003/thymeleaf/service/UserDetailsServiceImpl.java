package com.bree2003.thymeleaf.service;

import com.bree2003.thymeleaf.entity.UserEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser = userService.getUserByUsername(username);
        if(optionalUser.isPresent()) {
            session.setAttribute("user_session_id", optionalUser.get().getId());
            UserEntity userEntity = optionalUser.get();
            return User.builder()
                    .username(userEntity.getUsername())
                    .password(userEntity.getPassword())
                    .roles()
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
