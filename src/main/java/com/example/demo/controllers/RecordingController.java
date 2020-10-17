package com.example.demo.controllers;

import com.example.demo.models.Client;
import com.example.demo.models.Day;
import com.example.demo.models.Time;
import com.example.demo.models.User;
import com.example.demo.repos.ClientRepository;
import com.example.demo.service.ClientService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecordingController {

    public final ClientRepository clientRepository;
    public final UserService userService;
    public final ClientService clientService;

    @GetMapping("/recording")
    public String recordingAdd (Model model){
        List <User> users = userService.users();
        model.addAttribute("users", users);
        return "recording";
    }
    @PostMapping("/recording")
    public String recordingPostAdd (@RequestParam String localDate,
                                    @RequestParam String time,
                                    @Valid Client client,
                                    Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(localDate, formatter);
        Day day = new Day();
        day.setLocalDate(localDate1);
        day.setClient(client);
        Time time1 = new Time();
        time1.setTime(time);
        time1.setClient(client);
        clientService.addClient(client, day, time1);
        return "redirect:/recording";

    }
}
