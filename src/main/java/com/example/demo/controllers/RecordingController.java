package com.example.demo.controllers;

import com.example.demo.models.Client;
import com.example.demo.models.User;
import com.example.demo.repos.ClientRepository;
import com.example.demo.service.ClientService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
        clientService.addClient(client, localDate, time);
        return "redirect:/recording";
    }
}
