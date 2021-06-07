package com.cotiviti.moviereservation.movie.repo;

import com.cotiviti.moviereservation.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT COUNT(id) AS total FROM movie", nativeQuery = true)
    Map<String, Object> getMoviesCount();
}
