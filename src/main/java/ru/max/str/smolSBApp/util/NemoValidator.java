package ru.max.str.smolSBApp.util;//package ru.max.str.eExitBoot.util;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//import ru.max.str.eExitBoot.models.Nemo;
//
//
//@Component
//public class NemoValidator implements Validator {
//
//    private final EmergencyDao emergencyDao;
//
//    @Autowired
//    public NemoValidator(EmergencyDao emergencyDao) {
//        this.emergencyDao = emergencyDao;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Nemo.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Nemo nemo = (Nemo) target;
//        if(emergencyDao.validShowLog(nemo.getLogins()).isPresent())
//            errors.rejectValue("logins", "", "Пользователь с таким логином уже есть");
//        if(emergencyDao.validShowPas(nemo.getPasswords()).isPresent())
//            errors.rejectValue("passwords", "", "Пользователь с таким паролем уже есть");
//
//
//    }
//
//    public void antiValidate(Object target, Errors errors) {
//        Nemo nemo = (Nemo) target;
//        if(!emergencyDao.validShowLog(nemo.getLogins()).isPresent())
//            errors.rejectValue("logins", "", "Введите Ваш логин");
//        if(!emergencyDao.validShowPas(nemo.getPasswords()).isPresent())
//            errors.rejectValue("passwords", "", "Введите Ваш пароль");
//    }
//}
