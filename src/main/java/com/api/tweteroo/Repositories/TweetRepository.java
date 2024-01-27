package com.api.tweteroo.Repositories;

import org.springframework.stereotype.Repository;
import com.api.tweteroo.Models.TweetModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Long>{
    
    @Query(value = " SELECT * from tweets WHERE user_id = :userId ", nativeQuery = true)
    public List<TweetModel> findByUserId (@Param("userId") Long userId);
}
