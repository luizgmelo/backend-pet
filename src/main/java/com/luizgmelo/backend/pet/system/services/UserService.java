package com.luizgmelo.backend.pet.system.services;

import com.luizgmelo.backend.pet.system.dto.UserDTO;
import com.luizgmelo.backend.pet.system.models.UserModel;
import com.luizgmelo.backend.pet.system.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO findById(UUID id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getRoles());
    }


}
