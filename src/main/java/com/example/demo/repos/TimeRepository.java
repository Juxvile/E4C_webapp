package com.example.demo.repos;

import com.example.demo.models.Client;
import com.example.demo.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
    Iterable <Time> findByClient (Client client);
}
