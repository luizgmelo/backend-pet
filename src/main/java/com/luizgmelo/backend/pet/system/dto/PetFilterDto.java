package com.luizgmelo.backend.pet.system.dto;

import com.luizgmelo.backend.pet.system.enums.PetSex;

public record PetFilterDto(String firstName, String lastName, PetSex sex, Integer age, Double weight,
                           String breed, String street, Integer houseNumber, String city) { ;
}
