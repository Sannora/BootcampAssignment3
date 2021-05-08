package com.company.dataAccess.concretes;

import com.company.dataAccess.abstracts.UserDao;
import com.company.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class MySQLDao implements UserDao {

    @Override
    public void login(User user) {
    }

    @Override
    public void register(User user) {
        userList.add(user);
        System.out.println(user.getFirstName() + " successfully added to MySQL server.");
    }

    @Override
    public void removeUser(User user) {
        userList.remove(user);
        System.out.println(user.getFirstName() + " successfully removed from MySQL server.");
    }

    @Override
    public void updateUser(User user) {
        System.out.println(user.getFirstName() + " credentials updated.");
    }

    @Override
    public List<User> getAll() {
        return userList;
    }
}
