package com.example.demo.service;


import com.example.demo.models.*;
import com.example.demo.repos.ClientRepository;
import com.example.demo.repos.DayRepository;
import com.example.demo.repos.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ClientService {
    public final ClientRepository clientRepository;
    public final DayRepository dayRepository;
    public final TimeRepository timeRepository;
    public final DayService dayService;
    public final TimeService timeService;

    @Transactional
    public void addClient(Client client, String localDate, String time) {
        dayService.saveDay(localDate, client);
        timeService.saveTime(time, client);
        clientRepository.save(client);
    }

}