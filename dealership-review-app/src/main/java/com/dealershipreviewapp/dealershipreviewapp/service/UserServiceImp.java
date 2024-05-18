package com.dealershipreviewapp.dealershipreviewapp.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dealershipreviewapp.dealershipreviewapp.dtos.UserDTO;
import com.dealershipreviewapp.dealershipreviewapp.entity.User;
import com.dealershipreviewapp.dealershipreviewapp.exception.EntityNotFoundException;
import com.dealershipreviewapp.dealershipreviewapp.mappers.UserMapper;
import com.dealershipreviewapp.dealershipreviewapp.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDTO saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));;
        return UserMapper.userToUserDTO(userRepository.save(user));
    }

    @Override
    public UserDTO getUser(Long id) {
        User unwrappedUser = unwrappUser(userRepository.findById(id), id);
        return UserMapper.userToUserDTO(unwrappedUser);
    }

    @Override
    public User getUser(String username) {
        User unwrappedUser = unwrappUser(userRepository.findByUsername(username), 404L);
        return unwrappedUser;
    }

    static User unwrappUser(Optional<User> entity, Long id) {
        if(entity.isPresent()) return entity.get();
        throw new EntityNotFoundException(id, User.class);
    }

}
