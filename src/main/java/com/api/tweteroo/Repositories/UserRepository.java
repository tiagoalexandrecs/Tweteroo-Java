package com.api.tweteroo.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tweteroo.Models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    
} 
