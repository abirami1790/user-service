package com.tw.userservice.Controller;
import com.tw.userservice.Model.User;
import com.tw.userservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserCotroller {
    private final UserService userService;


    @Autowired
    public UserCotroller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> users() {
        return (List<User>) userService.getUsers(2L);
    }

    @PostMapping
    public User createUser(@RequestParam String name, @RequestParam int age) {
        User user = new User(name, age);
        return userService.create(user);
    }


    @GetMapping("/{userId}")
    public User getUser(@PathVariable long userId) {
        return userService.user(userId);
    }


}
