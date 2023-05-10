package ru.max.str.smolSBApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.max.str.smolSBApp.models.Nemo;
import ru.max.str.smolSBApp.repositories.NemoRepository;
import ru.max.str.smolSBApp.security.NemoDetails;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class NemoService {

    private final PasswordEncoder passwordEncoder;

    private final NemoRepository nemoRepository;

    @Autowired
    public NemoService(PasswordEncoder passwordEncoder, NemoRepository nemoRepository) {
        this.passwordEncoder = passwordEncoder;
        this.nemoRepository = nemoRepository;
    }

    public Nemo findOne() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        NemoDetails principal = (NemoDetails) authentication.getPrincipal();
        Nemo nemo = principal.getNemo();
        return nemo;
    }

    @Transactional
    public void update(Nemo updateNemo) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        NemoDetails principal = (NemoDetails) authentication.getPrincipal();
        Nemo nemo = principal.getNemo();
        int id = nemo.getId();
        updateNemo.setId(id);
        nemoRepository.save(updateNemo);
    }

    @Transactional
    public void createUser(Nemo nemo) {

        nemo.setPassword(passwordEncoder.encode(nemo.getPassword()));
        nemo.setRole("ROLE_USER");
        nemo.setCreate_date(LocalDateTime.now());
        nemoRepository.save(nemo);
    }

    @Transactional
    public void remove() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        NemoDetails principal = (NemoDetails) authentication.getPrincipal();
        Nemo nemo = principal.getNemo();
        int id = nemo.getId();
        nemoRepository.deleteById(id);
        SecurityContextHolder.clearContext();
    }
    public boolean findByUsername(Nemo nemo) {
        Optional<Nemo> entityNemo = nemoRepository.findByUsername(nemo.getUsername());
            if(entityNemo.isEmpty()) {
                return false;
        }
        return true;
    }

}
