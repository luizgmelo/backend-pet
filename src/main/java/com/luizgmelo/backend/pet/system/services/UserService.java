package com.luizgmelo.backend.pet.system.services;

import com.luizgmelo.backend.pet.system.dto.*;
import com.luizgmelo.backend.pet.system.enums.UserRole;
import com.luizgmelo.backend.pet.system.infra.security.TokenService;
import com.luizgmelo.backend.pet.system.models.UserModel;
import com.luizgmelo.backend.pet.system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final TokenService tokenService;


    public UserDTO findById(UUID id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getRoles());
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {
        UserModel user = userRepository.findByEmail(dto.email()).orElseThrow(()-> new RuntimeException("Login ou Senha incorreto"));
        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            return null;
        }
        String token = tokenService.generateToken(user);
        return new LoginResponseDTO(token);
    }

    public RegisterResponseDTO register(RegisterRequestDTO dto) {
        Optional<UserModel> user = userRepository.findByEmail(dto.email());
        if (user.isPresent()) {
            return null;
        }
        String passwordHashed = passwordEncoder.encode(dto.password());
        UserModel newUser = new UserModel();
        newUser.setName(dto.name());
        newUser.setEmail(dto.email());
        newUser.setPassword(passwordHashed);
        newUser.setRoles(Set.of(UserRole.USER));
        userRepository.save(newUser);
        return new RegisterResponseDTO("Usuário cadastrado com sucesso");
    }


}
