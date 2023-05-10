package ru.max.str.smolSBApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.max.str.smolSBApp.models.Nemo;

import java.util.Optional;

@Repository
public interface NemoRepository extends JpaRepository<Nemo, Integer> {
    Optional<Nemo> findByUsername(String username);
}
