package com.example.demo.service;

import com.example.demo.models.Client;
import com.example.demo.models.Time;
import com.example.demo.repos.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeService {

    public final TimeRepository timeRepository;


    public void saveTime (String time, Client client){
        Time time1 = new Time();
        time1.setTime(time);
        time1.setClient(client);
        timeRepository.save(time1);
    }
}
