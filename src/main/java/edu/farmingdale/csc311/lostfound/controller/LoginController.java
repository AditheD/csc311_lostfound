package edu.farmingdale.csc311.lostfound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "registered", required = false) String registered,
                        @RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {

        if (registered != null) {
            model.addAttribute("message", "Account created. Please sign in.");
        }
        if (error != null) {
            model.addAttribute("errorMessage", "Wrong username or password.");
        }
        if (logout != null) {
            model.addAttribute("message", "You have signed out.");
        }

        return "login";
    }
}
