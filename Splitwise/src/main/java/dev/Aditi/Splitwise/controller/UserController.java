package dev.Aditi.Splitwise.controller;

import dev.Aditi.Splitwise.Exception.UserLoginInvalidDetailsException;
import dev.Aditi.Splitwise.Exception.UserRegistrationInvalidDetailsException;
import dev.Aditi.Splitwise.dto.UserLoginRequestDTO;
import dev.Aditi.Splitwise.dto.UserRegistrationRequestDTO;
import dev.Aditi.Splitwise.mapper.EntityDTOMapper;
import dev.Aditi.Splitwise.model.User;
import dev.Aditi.Splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
  @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO)
  {
    validateUserRegistrationDTO(userRegistrationRequestDTO);
    User savedUser =  userService.signUp(userRegistrationRequestDTO.getName(),  userRegistrationRequestDTO.getEmail(), userRegistrationRequestDTO.getPassword());
    return  ResponseEntity.ok(EntityDTOMapper.toDTO(savedUser));

  }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO userLoginRequestDTO)
    {
        validateUserLoginRequestDTO(userLoginRequestDTO);
        User savedUser = userService.login(userLoginRequestDTO.getEmail(),userLoginRequestDTO.getPassword());
      return   ResponseEntity.ok(EntityDTOMapper.toDTO(savedUser));


    }
  private  void validateUserRegistrationDTO (UserRegistrationRequestDTO requestDTO)
  {
        if(requestDTO.getEmail()==null||
        requestDTO.getPassword()==null||
        requestDTO.getName()==null)
            throw new UserRegistrationInvalidDetailsException("Invalid Sign Up Data");
  }

  private void validateUserLoginRequestDTO(UserLoginRequestDTO userLoginRequestDTO)
  {
      if(userLoginRequestDTO.getEmail()==null||userLoginRequestDTO.getPassword()==null)
      {
          throw new UserLoginInvalidDetailsException("Invalid login details");
      }
  }
}
