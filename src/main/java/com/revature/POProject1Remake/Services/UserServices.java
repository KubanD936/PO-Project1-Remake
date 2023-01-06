package com.revature.POProject1Remake.Services;

import com.revature.POProject1Remake.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserServices extends JpaRepository<User, Integer> {
    Optional<User> findById(int id);

    Optional<User> findByUsername(String username);

}
