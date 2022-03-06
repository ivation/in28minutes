package com.in28minutes.in28minutes.repository;

import com.in28minutes.in28minutes.entity.User;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
  User findById(long id);
  User save(User user);
}
