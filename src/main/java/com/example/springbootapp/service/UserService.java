package com.example.springbootapp.service;

import com.example.springbootapp.entity.User;
import com.example.springbootapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

   private UserRepository userRepository;

   @Autowired
   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public List<User> getAllUsers() {
      return userRepository.findAll();
   }

   public User getUser(int id) {
      return userRepository.findById(id).orElse(null);
   }

   public void createUser(User user) {
      userRepository.save(user);
   }

//   public void updateUser(User user) {
//      userDao.updateUser(user);
//   }


   public void deleteUser(int id) {
      userRepository.deleteById(id);
   }
}
