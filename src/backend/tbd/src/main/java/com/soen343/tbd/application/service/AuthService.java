package com.soen343.tbd.application.service;

import com.soen343.tbd.infrastructure.persistence.entity.User;
import com.soen343.tbd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String email, String password) {
        // Debug logging (removed for production)

        // Find user by email in database
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            // User not found
            return false;
        }

        User user = userOptional.get();

        // Check if password matches
        boolean passwordMatches;

        // Check if the stored password looks like it's hashed (starts with $2a, $2b, etc.)
        if (user.getPassword() != null && user.getPassword().startsWith("$2")) {
            // Password is hashed, use BCrypt comparison
            passwordMatches = passwordEncoder.matches(password, user.getPassword());
        } else {
            // Password is plain text (not recommended for production)
            passwordMatches = password.equals(user.getPassword());
        }

        return passwordMatches;
    }

    /**
     * Register a new user with the given details
     *
     * @param fullName user's full name
     * @param email    user's email address
     * @param password user's password (will be encoded)
     */
    public void registerUser(String fullName, String email, String password) {
        // Create a new user entity
        User newUser = new User();
        newUser.setFullName(fullName);
        newUser.setEmail(email);

        // Hash the password before saving
        String encodedPassword = passwordEncoder.encode(password);
        newUser.setPassword(encodedPassword);

        // Set any default values or roles if needed
        // e.g., newUser.setRole("USER");

        // Save the user to the database
        userRepository.save(newUser);
    }
}
