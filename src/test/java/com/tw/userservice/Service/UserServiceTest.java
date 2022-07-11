package com.tw.userservice.Service;

import com.tw.userservice.Model.User;
import com.tw.userservice.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class UserServiceTest {
    @InjectMocks
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;
    @Test
    void getUsers() {
        long l = 1l;
        userService.getUsers(l);


        List<User> userList;

    }

    @Test
    void create() {
    }

    @Test
    void user() {
    }
}