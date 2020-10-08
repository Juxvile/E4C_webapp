package com.example.demo.controllers;

import com.example.demo.models.Client;
import com.example.demo.repos.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public String records (Model model){
        Iterable <Client> clients = clientRepository.findAll();
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
