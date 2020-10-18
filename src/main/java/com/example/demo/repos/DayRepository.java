package com.example.demo.repos;

import com.example.demo.models.Client;
import com.example.demo.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Long> {
    Iterable <Day> findByClient (Client client);
}
