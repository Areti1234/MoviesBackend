package dev.areti.movies.controller;


import dev.areti.movies.model.Register;
import dev.areti.movies.repository.RegisterRepositiry;
import dev.areti.movies.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody Register register)
    {

        return registerService.createUser(register);
    }
    @GetMapping("/api/v1/{email}/{password}")
    public ResponseEntity<String> loginUser(@PathVariable String email, @PathVariable String password){

        return registerService.loginUser(email,password);
    }
}
