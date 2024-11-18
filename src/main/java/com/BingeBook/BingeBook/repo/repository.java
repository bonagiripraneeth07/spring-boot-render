package com.BingeBook.BingeBook.repo;

import com.BingeBook.BingeBook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
