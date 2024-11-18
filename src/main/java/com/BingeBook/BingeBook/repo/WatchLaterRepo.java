package com.BingeBook.BingeBook.repo;

import com.BingeBook.BingeBook.model.WatchLater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchLaterRepo extends JpaRepository<WatchLater,Integer> {
//    @Modifying
//    @Query(value = "UPDATE watchlater SET watchlater = array_append(watchlater,:movieId) WHERE id = :id", nativeQuery = true)
//    void appendMovieIdToWatched(@Param("id") int id, @Param("movieId") Integer movieId);
@Modifying
@Query(value = "UPDATE watchlater SET watchlater = watchlater || :movieIds WHERE id = :id", nativeQuery = true)
void appendMovieIdsToWatched(@Param("id") int id, @Param("movieIds") List<Integer> movieIds);

}
