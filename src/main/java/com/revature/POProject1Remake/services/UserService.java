package com.revature.POProject1Remake.services;

import com.revature.POProject1Remake.dtos.ResetPasswordRequest;
import com.revature.POProject1Remake.exceptions.UsernameDoesntExistException;
import com.revature.POProject1Remake.models.User;
import com.revature.POProject1Remake.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findById(int id){
        return userRepository.getById(id);
    }
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }
    public Optional<User> findByCredentials(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public User resetPassword(ResetPasswordRequest resetPasswordRequest) {
        User updateUser = userRepository.findByUsername(resetPasswordRequest.getUsername()).isPresent()?userRepository.findByUsername(resetPasswordRequest.getUsername()).get():null;

        if(updateUser==null){
            throw new UsernameDoesntExistException("Email doesn't exist");
        }
        return userRepository.save(updateUser);
    }
}
