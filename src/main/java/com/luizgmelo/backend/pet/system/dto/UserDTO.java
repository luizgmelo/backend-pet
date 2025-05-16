package com.luizgmelo.backend.pet.system.dto;

import com.luizgmelo.backend.pet.system.enums.UserRole;

import java.util.Set;
import java.util.UUID;

public record UserDTO(UUID id, String name, String email, Set<UserRole> roles) {
}
