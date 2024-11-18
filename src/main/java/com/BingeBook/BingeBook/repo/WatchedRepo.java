package com.BingeBook.BingeBook.repo;

import com.BingeBook.BingeBook.model.Watched;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchedRepo extends JpaRepository<Watched,Integer> {
      List<Watched> findByUserid( int id) ;
}
