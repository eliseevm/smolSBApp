package ru.max.str.smolSBApp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.max.str.smolSBApp.models.Nemo;
import ru.max.str.smolSBApp.services.NemoService;
import ru.max.str.smolSBApp.services.RegistrationService;


@Controller
@RequestMapping("/select")
public class SelectController {
    private final NemoService nemoService;
    @Autowired
    public SelectController(NemoService nemoService) {
        this.nemoService = nemoService;
    }

    // Метод выводит форму для ввода логина и пароля
    @GetMapping("/sign_in")
    public String selectAccount(@ModelAttribute("nemo") Nemo nemo) {
       // model.addAttribute("nemo", emergencyDao.show(nemo.getPasswords()));
        return "sign_in";
    }

    // Метод выводит заполненую форму по логину и паролю
    @GetMapping("/select")
    public String convertIdFromPass(Model model) {
        model.addAttribute("nemo", nemoService.findOne());
        return "show_completed_form";
    }

    @GetMapping("/register")
    public String registr() {
        return "terms_for_reg";
    }

}

