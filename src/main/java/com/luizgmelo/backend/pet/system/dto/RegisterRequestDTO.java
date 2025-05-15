package com.luizgmelo.backend.pet.system.dto;

import com.luizgmelo.backend.pet.system.enums.UserRole;

import java.util.Set;

public record RegisterRequestDTO(String name, String email, String password, Set<UserRole> roles) {
}
