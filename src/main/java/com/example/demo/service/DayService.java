package com.example.demo.service;

import com.example.demo.models.Day;
import com.example.demo.repos.ClientRepository;
import com.example.demo.repos.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class DayService {

//    public final DayRepository dayRepository;
//
//    public void parsingDay(Day day) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate1 = LocalDate.parse(localDate, formatter);
//        Day day = new Day();
//        day.setLocalDate(localDate1);
//        dayRepository.save(day);
//
//    }
}
