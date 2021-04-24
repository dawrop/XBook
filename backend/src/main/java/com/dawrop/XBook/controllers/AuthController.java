package com.dawrop.XBook.controllers;

import com.dawrop.XBook.models.ERole;
import com.dawrop.XBook.models.Role;
import com.dawrop.XBook.models.User;
import com.dawrop.XBook.payload.request.SignupRequest;
import com.dawrop.XBook.payload.response.MessageResponse;
import com.dawrop.XBook.repositories.RoleRepository;
import com.dawrop.XBook.repositories.UserRepository;
import com.dawrop.XBook.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin("http://localhost:8081")
@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Email already taken!"));
        }

        if (!signupRequest.getPassword().equals(signupRequest.getRepeatPassword())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Passwords don't match!"));
        }

        User user = new User(signupRequest.getName(),
                                signupRequest.getSurname(),
                                encoder.encode(signupRequest.getPassword()),
                                signupRequest.getEmail());

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Role not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                        .orElseThrow(() -> new RuntimeException("Role not found."));
                        roles.add(adminRole);
                        break;
                    case "vip":
                        Role vipRole = roleRepository.findByName(ERole.ROLE_VIP)
                                .orElseThrow(() -> new RuntimeException("Role not found."));
                        roles.add(vipRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Role not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User succesfully created!"));
    }
}
