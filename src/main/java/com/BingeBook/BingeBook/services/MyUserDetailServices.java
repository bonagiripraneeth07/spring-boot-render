package com.BingeBook.BingeBook.services;

import com.BingeBook.BingeBook.model.User;
import com.BingeBook.BingeBook.model.UserPricipal;
import com.BingeBook.BingeBook.repo.repository;

import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServices implements UserDetailsService {

    @Autowired
    private repository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // User user= repo.findByUsername(username);
        User user = repo.findByUsername(username);
        if (user==null) {
            System.out.println("User 404" );
            System.out.println(username );
            throw new UsernameNotFoundException("User 404");
        }
         return new UserPricipal(user);

    }
}
