package com.BingeBook.BingeBook.controller;


import com.BingeBook.BingeBook.model.*;
import com.BingeBook.BingeBook.repo.repository;
import com.BingeBook.BingeBook.services.UserServices;
import com.BingeBook.BingeBook.services.WatchBucketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class home {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
   private UserServices userServices;
    @Autowired
  private   WatchBucketServices watchBucketServices;


    @GetMapping("home")
public String hello(){
    return "hello";
}
@PostMapping("register")
public String  register(@RequestBody User user){
    System.out.println(user);
//    user.setPassword(passwordEncoder.encode(user.getPassword()));
//    //user.setRoles("USER"); // Default role
   return userServices.addUser(user);


}
@PostMapping("login")
public long login(@RequestBody User user){
    System.out.println(user.getUsername());
    System.out.println(user.getPassword());


    return userServices.findUser(user.getUsername(), user.getPassword());
}
@GetMapping("/users")
    public List<User> allUsers(){
       return userServices.allUsers();
}
@GetMapping("hello")
    public String home(){
       return "hello";
}

// @GetMapping("watchbucket/{id}")
//    public Watched watchBucket(@PathVariable int id){
//    System.out.println(id);
//        return  watchBucketServices.watched(id);
//
//}
@GetMapping("watchbucket/watched/{id}")
    public List<Watched> watched(@PathVariable int id){
    System.out.println("from 71 home + id   " + id );
    return watchBucketServices.watched(id);
    }
@GetMapping("watchbucket/watchlater/{id}")
    public   WatchLater  watchLater(@PathVariable int id){
    System.out.println("from 75 home + id   " + id );
    return watchBucketServices.watchlater(id);
}
@PostMapping("addwatchlater")
    public void addWacthLater(@RequestBody WatchLater watchLater){
        watchBucketServices.addWatchLater(watchLater);
}
@PostMapping("addwatched")
    public void addWatched(@RequestBody Watched watched){
    System.out.println(watched);
        watchBucketServices.addWatched(watched);
}
}
