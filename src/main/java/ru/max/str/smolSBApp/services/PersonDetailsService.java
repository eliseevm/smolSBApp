package ru.max.str.smolSBApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.max.str.smolSBApp.models.Nemo;
import ru.max.str.smolSBApp.repositories.NemoRepository;
import ru.max.str.smolSBApp.security.NemoDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final NemoRepository nemoRepository;

    @Autowired
    public PersonDetailsService(NemoRepository nemoRepository) {
        this.nemoRepository = nemoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Nemo> person = nemoRepository.findByUsername(username);

        if (person.isEmpty()) throw new UsernameNotFoundException("Здесь ничего нет");

        return new NemoDetails(person.get());
    }
}
