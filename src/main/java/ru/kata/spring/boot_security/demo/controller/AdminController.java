package ru.kata.spring.boot_security.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    private final RoleService roleService;

    @GetMapping
    public String getAllUsers(@ModelAttribute("user") User user, Principal principal, Model model) {
        User authenticatedUser = userService.getByEmail(principal.getName());
        model.addAttribute("authenticatedUser", authenticatedUser);
        model.addAttribute("roleOfAuthenticatedUser", authenticatedUser.getRoles());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("AllRoles", roleService.getAllRoles());
        return "admin";
    }

    @GetMapping("/add")
    public String createNewUser(Model model, User user) {
        model.addAttribute("user", user);
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("AllRoles", roles);
        return "redirect:/admin";
    }

    @PostMapping("/add")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "redirect:/admin";
    }

    @PostMapping("/saveUpdatedUser/{id}")
    public String saveUpdatedUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}
