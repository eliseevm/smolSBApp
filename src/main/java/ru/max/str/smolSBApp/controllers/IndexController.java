package ru.max.str.smolSBApp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.max.str.smolSBApp.models.Nemo;
import ru.max.str.smolSBApp.services.NemoService;
import ru.max.str.smolSBApp.validator.NemoValidator;

@Controller
@RequestMapping("/index")
public class IndexController {
    private final NemoService nemoService;
    private final NemoValidator nemoValidator;

    @Autowired
    public IndexController(NemoService nemoService, NemoValidator nemoValidator) {
        this.nemoService = nemoService;
        this.nemoValidator = nemoValidator;
    }

    // Метод получает стартовою страницу
    @GetMapping
    public String index() {
        return "home";
    }

    // Метод выводит правила испрльзования сервиса для ознакомления
    @GetMapping("/termsOfUse")
    public String terms() {
        return "terms_of_use";
    }

    // Метод выводит правила испрльзования сервиса с кнопками для регистрации
    @GetMapping("/termsForReg")
    public String termsForReg() {
        return "terms_for_reg";
    }

    // Метод отправляет форму для заполнения новым пользователем
    @GetMapping("/getemptyform")
    public String getEmptyForm(@ModelAttribute("emptyform") Nemo nemo) {
        return "empty_form";
    }

    // Метод проверяет правильность заполнения формы и сохраняет данные из формы в БД
    @PostMapping("/reg")
    public String createNewNemo(@ModelAttribute("emptyform")
                                @Valid Nemo nemo, BindingResult bindingResult, Model model) {
        nemoValidator.validate(nemo, bindingResult);
        if (bindingResult.hasErrors())
            return "empty_form";

        nemoService.createUser(nemo);
        model.addAttribute("nemo", nemoService.findOne());

        return "show_completed_form";
    }

    // Метод выводит данные из БД для редактирования
    @GetMapping("/editform")
    public String editForm(Model model) {
        model.addAttribute("editform", nemoService.findOne());
        return "show_form_for_edit";
    }

    // Метод для сохранения обновленных данных в БД
    @PatchMapping("/update")
    public String update(@ModelAttribute("editform")
                         @Valid Nemo nemo, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors())
            return "show_form_for_edit";

        nemoService.update(nemo);
        model.addAttribute("nemo", nemo);
        return "redirect:/select/sign_in";
    }

    // Метод удаляет форму со всеми данными
    @DeleteMapping("/deleteForm")
    public String remove() {
        nemoService.remove();
        return "confirm_deletion";
    }
}

