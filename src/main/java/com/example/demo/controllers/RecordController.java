package com.example.demo.controllers;

import com.example.demo.models.Client;
import com.example.demo.models.User;
import com.example.demo.repos.ClientRepository;
import com.example.demo.repos.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
@RequestMapping("/records")
@RequiredArgsConstructor
public class RecordController {

    public final ClientRepository clientRepository;
    public final UserRepository userRepository;

    @GetMapping
    public String records (Model model,
                           @AuthenticationPrincipal User user){
        Iterable <Client> clients = clientRepository.findByUser(user);
        Iterable <User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("clients", clients);
        return "records";
    }
    @GetMapping("/add")
    public String recordsAdd (Model model){
        return "recordsadd";
    }
    @PostMapping("/add")
    public String recordsPostAdd (@Valid Client client,
                                  Model model) {
            clientRepository.save(client);
            return "redirect:/records";

    }
}
