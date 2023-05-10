package ru.max.str.smolSBApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.max.str.smolSBApp.models.Nemo;
import ru.max.str.smolSBApp.services.PersonDetailsService;

@Component
public class PersonValidator implements Validator {
    private final PersonDetailsService personDetailsService;

    @Autowired
    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Nemo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       Nemo nemo = (Nemo) target;

        try {
            personDetailsService.loadUserByUsername(nemo.getUsername());
        } catch (UsernameNotFoundException ignored) {
            return;
        }

        errors.rejectValue("username", "Человек с таким именем уже существует");
    }
}
