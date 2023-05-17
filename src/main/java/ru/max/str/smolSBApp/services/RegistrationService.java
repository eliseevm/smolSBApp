package ru.max.str.smolSBApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.max.str.smolSBApp.models.Nemo;
import ru.max.str.smolSBApp.repositories.NemoRepository;


@Service
public class RegistrationService {

    private final NemoRepository nemoRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(NemoRepository nemoRepository, PasswordEncoder passwordEncoder) {

        this.nemoRepository = nemoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Nemo nemo) {

       nemo.setPassword(passwordEncoder.encode(nemo.getPassword()));
        nemo.setRole("ROLE_USER");
        //nemo.setDescription("Student");
        nemoRepository.save(nemo);
    }
}