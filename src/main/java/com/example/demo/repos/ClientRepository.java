package com.example.demo.repos;

import com.example.demo.models.Client;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Iterable<Client> findByUser(User user);
}
