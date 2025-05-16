package com.luizgmelo.backend.pet.system.controllers;

import com.luizgmelo.backend.pet.system.dto.*;
import com.luizgmelo.backend.pet.system.enums.UserRole;
import com.luizgmelo.backend.pet.system.infra.security.TokenService;
import com.luizgmelo.backend.pet.system.models.UserModel;
import com.luizgmelo.backend.pet.system.repositories.UserRepository;
import com.luizgmelo.backend.pet.system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final TokenService tokenService;

    private final UserService userService;

    // TODO Create UserService for business logic
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO body) {
        UserModel user = userRepository.findByEmail(body.email()).orElseThrow(()-> new RuntimeException("Login ou Senha incorreto"));
        if (!passwordEncoder.matches(body.password(), user.getPassword())) {
            return ResponseEntity.badRequest().build();
        }
        String token = tokenService.generateToken(user);
        LoginResponseDTO response = new LoginResponseDTO(token);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO body) {
        Optional<UserModel> user = userRepository.findByEmail(body.email());
        if (user.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        String passwordHashed = passwordEncoder.encode(body.password());
        UserModel newUser = new UserModel();
        newUser.setName(body.name());
        newUser.setEmail(body.email());
        newUser.setPassword(passwordHashed);
        newUser.setRoles(Set.of(UserRole.USER));
        userRepository.save(newUser);
        RegisterResponseDTO response = new RegisterResponseDTO("Usuário cadastrado com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

}
