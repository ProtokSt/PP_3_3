package protok.training.bootstrap_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import protok.training.bootstrap_security.models.User;
import protok.training.bootstrap_security.services.UserService;
import protok.training.bootstrap_security.util.BaseRolesInit;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ROLE_USER')")
public class UserController {
    private final UserService userService;
    private final BaseRolesInit baseRolesInit;

    @Autowired
    public UserController(UserService userService, BaseRolesInit baseRolesInit) {
        this.userService = userService;
        this.baseRolesInit = baseRolesInit;
    }

    @GetMapping("/user")
    public String showPrincipalData(Model model, Principal principal) {
        System.out.println("user GET");
        List<User> accessUsers = new ArrayList<>();
        accessUsers.add(userService.findByUsername(principal.getName()));
        model.addAttribute("allUsers", accessUsers);
//        model.addAttribute("user", principal);
        return "/user";
    }
}
