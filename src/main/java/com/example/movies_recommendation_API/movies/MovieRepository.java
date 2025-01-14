package com.example.movies_recommendation_API.movies;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository  extends MongoRepository<Movie, Long> {

    @Query("{ '_id': { $in: ?0 } }")
    Page<Movie> findByIdIn(List<String> ids, Pageable pageable);

    @Query("{ 'id': ?0 }")
    Movie findOneById(Integer id);

    @Query("{ 'id': { $in: ?0 } }")
    Page<Movie> findByCustomIdIn(List<Integer> ids, Pageable pageable);

    List<Movie> findListByTitleContainingIgnoreCase(String keyword);

    @Query("{ 'credits.cast.name': { $regex: ?0, $options: 'i' } }")
    List<Movie> findListByCastName(String castName);

    @Query("{ '$and': [ { 'title': { '$regex': ?0, '$options': 'i' } }, { 'credits.cast.name': { '$regex': ?1, '$options': 'i' } } ] }")
    Page<Movie> findListByTitleAndCastName(String title, String castName, Pageable pageable);
}

