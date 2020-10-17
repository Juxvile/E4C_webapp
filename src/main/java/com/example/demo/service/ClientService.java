package com.example.demo.service;


import com.example.demo.models.*;
import com.example.demo.repos.ClientRepository;
import com.example.demo.repos.DayRepository;
import com.example.demo.repos.TimeRepository;
import com.example.demo.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClientService {
    public final ClientRepository clientRepository;
    public final DayRepository dayRepository;
    public final TimeRepository timeRepository;

    public void addClient(Client client, Day day, Time time) {
        dayRepository.save(day);
        timeRepository.save(time);
        clientRepository.save(client);
    }

}