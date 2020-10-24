package com.example.demo.service;

import com.example.demo.models.Client;
import com.example.demo.models.Day;
import com.example.demo.repos.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class DayService {

    public final DayRepository dayRepository;

    public void saveDay(String day, Client client) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(day, formatter);
        Day day1 = new Day();
        day1.setLocalDate(localDate);
        day1.setClient(client);
        dayRepository.save(day1);

    }
}
