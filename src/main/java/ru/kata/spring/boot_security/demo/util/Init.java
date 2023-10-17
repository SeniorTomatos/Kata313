package ru.kata.spring.boot_security.demo.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Init {

    private final UserService userService;
    private final RoleService roleService;

//    @PostConstruct
//    public void initializedDataBase() {
//        roleService.saveRole(new Role("ROLE_ADMIN"));
//        roleService.saveRole(new Role("ROLE_USER"));
//        Set<Role> adminRole = new HashSet<>();
//        Set<Role> userRole = new HashSet<>();
//        Set<Role> allRoles = new HashSet<>();
//        adminRole.add(roleService.getRoleById(1L));
//        userRole.add(roleService.getRoleById(2L));
//        allRoles.add(roleService.getRoleById(1L));
//        allRoles.add(roleService.getRoleById(2L));
//        userService.saveUser(new User("admin", 40, "admin@mail.ru", "admin", adminRole));
//        userService.saveUser(new User("Denis", 30, "denis@mail.ru","denis", userRole));
//        userService.saveUser(new User("Kata", 20, "kata@gmail.com","kata", allRoles));
//    }
}
