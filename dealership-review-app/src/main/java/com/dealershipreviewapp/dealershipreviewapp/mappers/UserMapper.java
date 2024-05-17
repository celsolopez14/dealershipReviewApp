package com.dealershipreviewapp.dealershipreviewapp.mappers;

import com.dealershipreviewapp.dealershipreviewapp.dtos.UserDTO;
import com.dealershipreviewapp.dealershipreviewapp.entity.User;

public class UserMapper {

    public static UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.id = user.getId();
        userDTO.username = user.getUsername();
        return userDTO;
    }
}
