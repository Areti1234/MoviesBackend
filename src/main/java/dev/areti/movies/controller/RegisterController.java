package dev.areti.movies.controller;


import dev.areti.movies.model.Register;
import dev.areti.movies.repository.RegisterRepositiry;
import dev.areti.movies.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody Register register)
    {

        return registerService.createUser(register);
    }
    @GetMapping("/{email}/{password}")
    public ResponseEntity<String> loginUser(@PathVariable String email, @PathVariable String password){

        return registerService.loginUser(email,password);
    }
}


//@RestController
//
//@RequestMapping("/api/v1/users")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        try {
//            User savedUser = userService.registerUser(user);
//            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//}