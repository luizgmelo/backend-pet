package com.luizgmelo.backend.pet.system.repositories;

import com.luizgmelo.backend.pet.system.enums.PetSex;
import com.luizgmelo.backend.pet.system.enums.PetType;
import com.luizgmelo.backend.pet.system.models.AddressModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PetFilter {
    private String firstName;
    private String lastName;
    private PetType type;
    private PetSex sex;
    private Integer age;
    private Double weight;
    private String breed;
    private AddressModel address;
}
