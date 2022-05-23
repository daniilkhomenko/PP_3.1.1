package com.example.springbootapp.service;

import com.example.springbootapp.entity.User;
import com.example.springbootapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

   private UserRepository userRepository;

   public UserServiceImpl(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public List<User> getAllUsers() {
      return userRepository.findAll();
   }

   public User getUser(int id) {
      return userRepository.findById(id).orElse(null);
   }
   @Transactional
   public void createUser(User user) {
      userRepository.save(user);
   }

   @Transactional
   public void deleteUser(int id) {
      userRepository.deleteById(id);
   }
}
