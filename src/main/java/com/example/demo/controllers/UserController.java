package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequiredArgsConstructor
public class UserController {

    public final UserRepository userRepository;

    public final UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "login";
    }

    @PostMapping("/login")
    public String logUser(@RequestParam String username,
                          @RequestParam String password,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            return "login";

        } else {
            return "redirect:/records";
        }
    }
}
