package com.dmc.service;

import com.dmc.model.User;

import java.util.List;

public interface UserService {

    void save(String username, String password);

    User findByUsername(String username);

    List<User> findAllUsers();
}
