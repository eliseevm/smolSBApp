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
public class NemoDetailsService implements UserDetailsService {

    private final NemoRepository nemoRepository;

    @Autowired
    public NemoDetailsService(NemoRepository nemoRepository) {
        this.nemoRepository = nemoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Nemo> nemo = nemoRepository.findByUsername(username);

        if (nemo.isEmpty()) throw new UsernameNotFoundException("Пользователь не найден !");

        return new NemoDetails(nemo.get());
    }
}
