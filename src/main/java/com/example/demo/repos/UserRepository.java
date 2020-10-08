package com.example.demo.repos;

import com.example.demo.models.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername (String username);
    User findByActivationCode(String code);
    User findByEmail(String email);

    List<User> findAll(Sort username);
}
