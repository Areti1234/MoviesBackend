package dev.areti.movies.service;


import dev.areti.movies.model.Register;
import dev.areti.movies.repository.RegisterRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepositiry registerRepositiry;

    public ResponseEntity<String> createUser(Register register) {
        try {
            Register userExists = registerRepositiry.findByEmail(register.getEmail());
            if (userExists == null) {
                registerRepositiry.save(register);
                return new ResponseEntity<>("Success: Admin Created Successfully with id:" + register.getId(), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Bad Request: Admin is exits with the mail:" + register.getEmail(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> loginUser(String email, String password)
    {
        try {
            Register user = registerRepositiry.findByEmail(email);
            if (user != null) {
                {
                    if(password.matches(user.getPassword())) {
                        return new ResponseEntity<>("User Login Success", HttpStatus.ACCEPTED);
                    }
                    else
                    {
                        return new ResponseEntity<>("Wrong User Credentials, Please try again", HttpStatus.NOT_ACCEPTABLE);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("No user created with this email: Please register" + email, HttpStatus.NOT_FOUND);

    }
}

//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    // Register user logic (same as before)
//    public User registerUser(User user) {
//        if (userRepository.findByEmail(user.getEmail()) != null) {
//            throw new RuntimeException("User already exists with email: " + user.getEmail());
//        }
//        return userRepository.save(user);
//    }
//
//    // Login user logic
//    public User loginUser(String email, String password) {
//        // Check if user exists
//        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            throw new RuntimeException("User not found with email: " + email);
//        }
//
//        // Validate password
//        if (!user.getPassword().equals(password)) {
//            throw new RuntimeException("Invalid credentials");
//        }
//
//        return user;  // Return the user object on successful login
//    }
//}
