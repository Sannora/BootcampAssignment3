package com.company.business.abstracts;

import com.company.entities.concretes.User;

import java.util.List;

public interface ValidationService {
    boolean isFirstNameValid(String firstName);
    boolean isLastNameValid(String lastName);
    boolean isEmailValid(String email);
    boolean isPasswordValid(String password);
    boolean doesEmailExist(String email, List<User> userList);
    boolean isAccountValid(User user, List<User> userList);
    boolean checkAll(boolean... credentials);
}
