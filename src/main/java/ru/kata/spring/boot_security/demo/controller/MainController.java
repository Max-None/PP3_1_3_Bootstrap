package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/main")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    public String showMainPage(Model model, Principal principal) {
        model.addAttribute("authorizedUser", userService.getUserByName(principal.getName()));
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        return "main";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.addUser(user);
        return "redirect:/main";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUserById(user);
        return "redirect:/main";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/main";
    }
}