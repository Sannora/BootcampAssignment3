package com.company.dataAccess.abstracts;

import com.company.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    List<User> userList = new ArrayList<>();
    void login(User user);
    void register(User user);
    void removeUser(User user);
    void updateUser(User user);
    List<User> getAll();
}
