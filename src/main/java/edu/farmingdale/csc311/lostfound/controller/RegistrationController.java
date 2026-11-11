package edu.farmingdale.csc311.lostfound.controller;

import edu.farmingdale.csc311.lostfound.item.AppUserRepository;
import edu.farmingdale.csc311.lostfound.user.AppUser;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    private final AppUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(
            AppUserRepository repository,
            PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        username = username.trim();

        if (username.length() < 3) {
            model.addAttribute("error",
                    "Username must be at least 3 characters.");
            return "register";
        }

        if (password.length() < 6) {
            model.addAttribute("error",
                    "Password must be at least 6 characters.");
            return "register";
        }

        if (repository.existsByUsername(username)) {
            model.addAttribute("error",
                    "Username is already taken.");
            return "register";
        }

        String encodedPassword = passwordEncoder.encode(password);

        AppUser user = new AppUser(username, encodedPassword);

        repository.save(user);

        return "redirect:/login?registered";
    }
}