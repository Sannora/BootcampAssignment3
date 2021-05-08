package com.company.business.concretes;

import com.company.business.abstracts.ValidationService;
import com.company.entities.concretes.User;

import java.util.List;
import java.util.regex.*;

public class ValidationManager implements ValidationService {

    public static final Pattern validEmailPattern =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean isFirstNameValid(String firstName) {
        if (firstName.length() < 2) {
            System.out.println("First name must contain at least two characters!");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isLastNameValid(String lastName) {
        if (lastName.length() < 2) {
            System.out.println("Last name must contain at least two characters!");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isEmailValid(String email) {
        return validEmailPattern.matcher(email).find();
    }

    @Override
    public boolean isPasswordValid(String password) {
        if (password.length() < 6) {
            System.out.println("Password can not contain less than six characters!");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean doesEmailExist(String email, List<User> userList) {
        for (User user : userList) {
            if (user.getEmail() == email) {
                System.out.println("The e-mail address you have entered is already in use by another user!");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isAccountValid(User user, List<User> userList) {
        if(checkAll(isFirstNameValid(user.getFirstName()),isLastNameValid(user.getLastName()),
                isEmailValid(user.getEmail()),isPasswordValid(user.getPassword()),doesEmailExist(user.getEmail(),userList))){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkAll(boolean... credentials) {
        for(boolean credential : credentials){
            if(credential == false){
                return false;
            }
        }
        return true;
    }

}



