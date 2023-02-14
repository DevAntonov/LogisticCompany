package com.example.logisticcompany.service;

import com.example.logisticcompany.model.User;

import java.util.List;

public interface UserService {
    public User save(User user);

    void saveUser(User user);

    List<Object> isUserPresent(User user);
}
