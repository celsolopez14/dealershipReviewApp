package com.dealershipreviewapp.dealershipreviewapp.service;

import com.dealershipreviewapp.dealershipreviewapp.dtos.UserDTO;
import com.dealershipreviewapp.dealershipreviewapp.entity.User;

public interface UserService {
    UserDTO saveUser(User user);
    UserDTO getUser(Long id);
}
