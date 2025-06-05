package com.luizgmelo.backend.pet.system.dto;

import com.luizgmelo.backend.pet.system.enums.PetSex;
import com.luizgmelo.backend.pet.system.enums.PetType;
import com.luizgmelo.backend.pet.system.models.PetModel;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record PetDTO(UUID id, String firstName, String lastName, PetType type, PetSex sex, Integer age, Double weight,
                     String breed, AddressDTO address, Instant createdAt) {
    public static PetDTO fromPet(PetModel p) {
        return new PetDTO(p.getId(), p.getFirstName(), p.getLastName(), p.getType(), p.getSex(), p.getAge(),
                p.getWeight(), p.getBreed(), AddressDTO.fromAddress(p.getAddress()), p.getCreatedAt());
    }
}
