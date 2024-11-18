package com.BingeBook.BingeBook.repo;

import com.BingeBook.BingeBook.model.WatchBucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchBucketRepo  extends JpaRepository<WatchBucket,Integer> {

}
