package com.luizgmelo.backend.pet.system.dto;

import com.luizgmelo.backend.pet.system.enums.PetSex;
import com.luizgmelo.backend.pet.system.enums.PetType;

public record PetRequestDTO(String firstName, String lastName, PetType type, PetSex sex,
                            String street, Integer houseNumber, String city,
                            Integer age, Double weight, String breed) {
}
