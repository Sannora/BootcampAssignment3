package com.company;

import com.company.Adapters.GoogleRegistrationAdapter;
import com.company.business.abstracts.UserService;
import com.company.business.abstracts.ValidationService;
import com.company.business.concretes.UserManager;
import com.company.business.concretes.ValidationManager;
import com.company.dataAccess.concretes.MySQLDao;
import com.company.dataAccess.concretes.OracleDao;
import com.company.entities.concretes.User;

public class Main {

    public static void main(String[] args) {

        UserManager userManager = new UserManager(new OracleDao());
        GoogleRegistrationAdapter googleRegistration = new GoogleRegistrationAdapter(new MySQLDao(),new ValidationManager(),new UserManager());

        userManager.register(new User(1,"melih","hocaoğlu","mmh.melih@gmail.com","123123"));
        googleRegistration.register(new User(2,"melij","hocaoğlu","mmh.melij@gmail.com","123123"));
    }
}
