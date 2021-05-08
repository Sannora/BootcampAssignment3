package com.company.business.abstracts;

import com.company.entities.concretes.User;

public interface UserService {
    void register(User user);
    void unregister(User user);
    void update(User user);
    void login(User user);
}
