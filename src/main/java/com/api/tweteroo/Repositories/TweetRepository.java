package com.api.tweteroo.Repositories;

import org.springframework.stereotype.Repository;
import com.api.tweteroo.Models.TweetModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Long>{
    
}
