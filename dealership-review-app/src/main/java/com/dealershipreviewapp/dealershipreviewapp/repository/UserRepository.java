package com.dealershipreviewapp.dealershipreviewapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dealershipreviewapp.dealershipreviewapp.entity.User;
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
