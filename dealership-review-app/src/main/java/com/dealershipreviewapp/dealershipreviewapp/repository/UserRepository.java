package com.dealershipreviewapp.dealershipreviewapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.dealershipreviewapp.dealershipreviewapp.entity.User;
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}
