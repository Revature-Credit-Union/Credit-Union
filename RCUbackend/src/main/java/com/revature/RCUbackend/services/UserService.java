package com.revature.RCUbackend.services;

import com.revature.RCUbackend.models.User;
import com.revature.RCUbackend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserService() {

    }

    // CREATE
    public void addUser(User user) {
        userRepo.save(user);
    }

    // READ
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(Integer user_id) {
        return userRepo.findById(user_id).orElse(null);
    }

    // UPDATE
    public void updateUser(User user) {
        userRepo.save(user);
    }

    // DELETE
    public void deleteUser(User user) {
        userRepo.delete(user);
    }
    
	public Optional<User> findByEmail(String email) {
		return this.userRepo.findByEmail(email);
	}
	
	public Optional<User> findByUsername(String username) {
		return this.userRepo.findByUsername(username);
	}
}
