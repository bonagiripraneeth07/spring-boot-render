package com.BingeBook.BingeBook.services;

import com.BingeBook.BingeBook.model.User;
import com.BingeBook.BingeBook.repo.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.nio.CharBuffer;
import java.util.List;

@Service
public class UserServices  {
    @Autowired
    repository repo ;
    @Autowired
    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public String addUser(User user){
        String name = user.getUsername();
        System.out.println(name + " 21 from username from host");
        User checkUser = repo.findByUsername(name);

        if (checkUser!=null)
        {
            return "USER Exists";
        }else {
            user.setPassword(encoder.encode(user.getPassword()));
            System.out.println(user.getPassword());
            repo.save(user);
            return "success";
        }

    }

    public List<User> allUsers() {
        return repo.findAll();
    }
   @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
    public long findUser(String username, String password) {
       User user = repo.findByUsername(username);
       if(user==null){
           return 404;
       }
        System.out.println(username + " " + password);
       if(passwordEncoder().matches(CharBuffer.wrap(password),user.getPassword())){
           System.out.println("success ful passowrd ");
           return user.getUserid();
       }else{
           System.out.println("not right password");
           return 404;

       }

//       if (user.getUserid()!=null){
//           System.out.println( user.getUserid() +  "  from userid    46 ");
//           return user.getUserid();
//       }else{
//           return 404;
//       }

//        if (user.getPassword().equals(password)){
//            System.out.println("yes password is correct");
//            return user.getUserid();
//        }else{
//            System.out.println("not wrong password");
//            return 404;
//        }
    }
}
