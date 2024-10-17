package dev.areti.movies.repository;


import dev.areti.movies.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisterRepositiry extends MongoRepository<Register, Integer> {
    public Register findByEmail(String email);
}

//
//    public Admin findByMail(String mail);
//    public Admin deleteAllByMail(String mail);
