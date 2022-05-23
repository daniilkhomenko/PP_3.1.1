
package com.example.springbootapp.service;


import com.example.springbootapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(int id);

    void createUser(User user);

    void deleteUser(int id);
}
