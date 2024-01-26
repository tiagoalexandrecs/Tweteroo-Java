package com.api.tweteroo.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.api.tweteroo.Models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    boolean existsByUsername(String username);

    @Query(value = " SELECT * from users WHERE username = :username ", nativeQuery = true)
    public UserModel findByUsername (@Param("username") String username);
} 
