package dev.Aditi.Splitwise.service;

import dev.Aditi.Splitwise.Exception.InvalidCredentialsException;
import dev.Aditi.Splitwise.Exception.UserDoesNotExistException;
import dev.Aditi.Splitwise.model.User;
import dev.Aditi.Splitwise.repository.UserRepository;
import dev.Aditi.Splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userReposiotry;


    @Override
    public User signUp(String name, String email, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

       User user = new User();
       user.setEmail(email);
       user.setName(name);
       user.setPassword(encoder.encode(password));
       userReposiotry.save(user);
       return  user;
    }

    public User login(String email,String password)
    {   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

       User savedUser =  userReposiotry.findUserByEmail(email);
       if(savedUser==null)
       {
           throw new UserDoesNotExistException("User Does Not Exist");
       }
       if(encoder.matches(password,savedUser.getPassword()))
       {
           return savedUser;
       }else
       {
           throw new InvalidCredentialsException("Invalid Credentials");
       }


    }
}
