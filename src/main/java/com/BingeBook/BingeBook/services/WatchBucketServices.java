package com.BingeBook.BingeBook.services;

import com.BingeBook.BingeBook.model.WatchBucket;
import com.BingeBook.BingeBook.model.WatchLater;
import com.BingeBook.BingeBook.model.Watched;
import com.BingeBook.BingeBook.repo.WatchBucketRepo;
import com.BingeBook.BingeBook.repo.WatchLaterRepo;
import com.BingeBook.BingeBook.repo.WatchedRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class WatchBucketServices {
//    @Autowired
//   private  WatchBucketRepo repo;
//    public WatchBucket find(int id) {
//        System.out.println("from services  " + id);
//
//    return repo.findById(id).orElse(new WatchBucket());
//    }
    @Autowired
    private WatchLaterRepo watchLaterRepo;
    @Autowired
    private WatchedRepo watchedRepo;

    public List<Watched> watched(int id ){
//        System.out.println( "from services +  " + id );
//        //return Collections.singletonList(watchedRepo.findById(id).orElse(new Watched()));
//        // List<Watched> watchedlist = new ArrayList<>();
//        List<Watched> watchedList = watchedRepo.findAll();
//        watchedList.forEach(System.out::println);
//         watchedlist.add(watchedRepo.findById(id).orElse(new Watched()));
//

         //return watchedRepo.findByIdWithDuplicates(id);
return watchedRepo.findByUserid(id);
    }

    public  WatchLater watchlater(int id) {

        return watchLaterRepo.findById(id).orElse(null);
    }
    @Transactional
    public void addWatchLater(WatchLater watchLater) {
        System.out.println(watchLater.getId() + " from 51 watchlater services");
        System.out.println(watchLater.getWatchlater() + " from watchlater ");
        int id = watchLater.getId();
        System.out.println(id);
        if (watchLaterRepo.findById(id)==null){
            watchLaterRepo.save(watchLater);
        }else{
            watchLaterRepo.appendMovieIdsToWatched(watchLater.getId(),watchLater.getWatchlater());
        }
    }

    public void addWatched(Watched watched) {
        System.out.println(watched + " from services");
        watchedRepo.save(watched);
    }
}
