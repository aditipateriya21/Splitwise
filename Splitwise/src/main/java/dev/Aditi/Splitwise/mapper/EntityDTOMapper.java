package dev.Aditi.Splitwise.mapper;

import dev.Aditi.Splitwise.dto.UserLoginResponseDTO;
import dev.Aditi.Splitwise.model.User;

public class EntityDTOMapper {
    public static UserLoginResponseDTO toDTO(User user )
    {
        UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
        userLoginResponseDTO.setId(user.getId());
        userLoginResponseDTO.setName(user.getName());
        userLoginResponseDTO.setEmail(user.getEmail());
        return  userLoginResponseDTO;

    }
}
