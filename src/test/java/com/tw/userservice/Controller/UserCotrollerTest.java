package com.tw.userservice.Controller;

import com.tw.userservice.Model.User;
import com.tw.userservice.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class UserControllerTest {
    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAllUsers() throws Exception {
        List<User> users = Arrays.asList(new User("Abirami", 32), new User("Dasarathan", 35));
        when(userService.getUsers(2L)).thenReturn(users);

        String jsonContent = "[{\"name\": \"Abirami\", \"age\" : 32}, {\"name\": \"Dasarathan\", \"age\" : 35}]";
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(content().json(jsonContent));

    }

    @Test
    void shouldCreateTheUser() throws Exception {
        User userToBeCreated = new User("User2", 30);
        User createdUser = new User("User2", 30);
        createdUser.setId(2L);
        when(userService.create(any())).thenReturn(createdUser);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("name", "User2")
                        .param("age", "30")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("User2"))
                .andExpect(jsonPath("$.age").value("30"));

        verify(userService, times(1)).create(userToBeCreated);
    }

    @Test
    void shouldReturnUserForProvidedUserId() throws Exception {
        User createdUser = new User("User2", 30);
        createdUser.setId(2L);
        when(userService.user(2L)).thenReturn(createdUser);

        mockMvc.perform(get("/api/users/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("User2"))
                .andExpect(jsonPath("$.age").value("30"));

        verify(userService, times(1)).user(2L);
    }



}
