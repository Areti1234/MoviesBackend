package dev.areti.movies.repository;


import dev.areti.movies.model.Register;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisterRepositiry extends MongoRepository<Register, ObjectId> {
    Register findByEmail(String email);
}

//
//    public Admin findByMail(String mail);
//    public Admin deleteAllByMail(String mail);
