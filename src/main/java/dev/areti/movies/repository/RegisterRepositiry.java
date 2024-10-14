package dev.areti.movies.repository;


import dev.areti.movies.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepositiry extends JpaRepository<Register, Integer> {
    public Register findByEmail(String email);
}

//
//    public Admin findByMail(String mail);
//    public Admin deleteAllByMail(String mail);
