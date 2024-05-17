package dev.Aditi.Splitwise.service;

import dev.Aditi.Splitwise.model.User;

public interface UserService {
    User signUp(String name, String email, String password);
    User login(String email,String password);
}
