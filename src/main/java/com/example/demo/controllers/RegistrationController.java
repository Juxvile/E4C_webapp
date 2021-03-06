package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    public final UserRepository userRepository;
    public final UserService userService;


    @GetMapping("/registration")
    public String registration(
            @RequestParam(name = "editUser", required = false, defaultValue = "") User user,
            Model model
    ){
        model.addAttribute("user", user);
        model.addAttribute("users", userService.users());

        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(
            @Valid User user,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("user", user);
            model.addAttribute("users", userService.users());
            userService.addUser(user);
            return "mailsend";
        } else {
            userService.addUser(user);
            return "redirect:/mailsend";
        }
    }

    @GetMapping("/mailsend")
    public String mailSendPage(
            Model model){
        model.addAttribute("message", "Вам на почту выслано письмо, перейдите по ссылке в письме для продолжения регистрации");
        return "mailsend";
    }

    @GetMapping("/activate/{code}")
    public String activate(
            Model model,
            @PathVariable String code
    ) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "Вы успешно активировали пользователя!");
        } else {
            model.addAttribute("message", "Код активации не найден");
        }
        return "activation";
    }
}
