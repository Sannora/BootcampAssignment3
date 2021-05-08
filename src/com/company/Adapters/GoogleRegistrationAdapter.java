package com.company.Adapters;

import com.company.business.abstracts.UserService;
import com.company.business.abstracts.ValidationService;
import com.company.dataAccess.abstracts.UserDao;
import com.company.entities.concretes.User;

public class GoogleRegistrationAdapter implements UserService{

    UserDao database;
    ValidationService validationService;
    UserService userService;

    public GoogleRegistrationAdapter(UserDao database, ValidationService validationService, UserService userService) {
        this.database = database;
        this.validationService = validationService;
        this.userService = userService;
    }


    @Override
    public void register(User user) {
        if(validationService.isAccountValid(user,database.getAll())){
            database.register(user);
            System.out.println("Registration via Google successful.");
        }
    }

    @Override
    public void unregister(User user) {
        if(validationService.isAccountValid(user,database.getAll())){
            database.removeUser(user);
        }
    }

    @Override
    public void update(User user) {
        if(validationService.isAccountValid(user,database.getAll())){
            database.updateUser(user);
        }
    }

    @Override
    public void login(User user) {
        if(validationService.isAccountValid(user,database.getAll())){
            database.login(user);
            System.out.println("Successfully logged in via Google account.");
        }

    }
}
