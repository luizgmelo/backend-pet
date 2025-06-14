package com.luizgmelo.backend.pet.system.repositories;

import com.luizgmelo.backend.pet.system.enums.PetSex;
import com.luizgmelo.backend.pet.system.models.Pet;
import com.luizgmelo.backend.pet.system.models.Pet_;
import org.springframework.data.jpa.domain.Specification;

public class PetSpecs {

    public static Specification<Pet> containsFirstName(String firstName) {
        return (root, query, builder) -> builder.like(root.get(Pet_.FIRST_NAME), firstName);
    }

    public static Specification<Pet> containsLastName(String lastName) {
        return (root, query, builder) -> builder.like(root.get(Pet_.LAST_NAME), lastName);
    }

    public static Specification<Pet> hasSex(PetSex sex) {
        return (root, query, builder) -> builder.lessThan(root.get(Pet_.SEX), sex);
    }

    public static Specification<Pet> hasAgeLessThanOrEqualTo(Integer age) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get(Pet_.AGE), age);
    }

    public static Specification<Pet> byFilters(PetFilter petFilter) {
        return containsFirstName(petFilter.getFirstName())
                .and(containsLastName(petFilter.getLastName()))
                .and(hasSex(petFilter.getSex()))
                .and(hasAgeLessThanOrEqualTo(petFilter.getAge()));
    }







}
