package ru.max.str.smolSBApp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.max.str.smolSBApp.models.Nemo;
import ru.max.str.smolSBApp.services.NemoService;

@Component
public class NemoValidator implements Validator {

    private final NemoService nemoService;

    public NemoValidator(NemoService nemoService) {
        this.nemoService = nemoService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Nemo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Nemo nemo = (Nemo) target;
        if (nemoService.findByUsername(nemo)) {
            errors.rejectValue("username", "", "Такой пользователь уже есть");
        }
    }
}
