package com.example.springbootapp.controller;

import com.example.springbootapp.entity.User;
import com.example.springbootapp.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    //    @GetMapping(value = "/users") //version1
    @RequestMapping(value = "/users", method = RequestMethod.GET) //version2
    public String getAllUsers(ModelMap model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users";
    }

    //    @PostMapping(value = "/users/newUser") //version1
    @RequestMapping(value = "/users/newUser", method = RequestMethod.POST) //version2
    public String createUser (User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    //    @PostMapping(value = "/users/delete/{id}") //version1
    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.POST) //version2
    public String deleteUser (@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    //    @GetMapping(value = "/users/edit/{id}") //version1
    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET) //version2
    public String editUser (@PathVariable int id, Model model) {
    model.addAttribute("user", userService.getUser(id));
        return "/edit";
    }

    //    @PostMapping(value = "/users/updateUser") //version1
    @RequestMapping(value = "/users/updateUser", method = RequestMethod.POST) //version2
    public String updateUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users";
    }
}
