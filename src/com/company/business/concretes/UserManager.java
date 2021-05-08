package com.company.business.concretes;

import com.company.business.abstracts.UserService;
import com.company.business.abstracts.ValidationService;
import com.company.dataAccess.abstracts.UserDao;
import com.company.entities.concretes.User;

public class UserManager implements UserService {

    public UserManager(){
    }

    ValidationService validationService = new ValidationManager();

    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        if(validationService.isAccountValid(user, userDao.getAll())){
            System.out.println(user.getFirstName() + " successfully registered to " + userDao +
                    " \n Please check " + user.getEmail() + " inbox for your activation link.");
            userDao.register(user);
        }else{
            System.out.println("Registration failed. Please check your credentials.");
        }
    }

    @Override
    public void unregister(User user) {
        if(validationService.isAccountValid(user, userDao.getAll())){
            System.out.println("Account " + user.getFirstName() + " successfully unregistered.");
            userDao.removeUser(user);
        }else{
            System.out.println("Failed to unregister. You have entered wrong credentials for user " + user.getFirstName());
        }
    }

    @Override
    public void update(User user) {
        if(validationService.isAccountValid(user, userDao.getAll())){
            System.out.println("Successfully updated credentials.");
            userDao.updateUser(user);
        }else{
            System.out.println("Failed to update credentials. You have entered wrong credentials for user " + user.getFirstName());
        }
    }

    @Override
    public void login(User user) {
        if(validationService.isAccountValid(user, userDao.getAll())){
            System.out.println("Login successful");
            userDao.login(user);
        }else{
            System.out.println("Login failed. Please check your credentials.");
        }
    }
}
