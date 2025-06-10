package com.luizgmelo.backend.pet.system.repositories;

import com.luizgmelo.backend.pet.system.enums.PetSex;
import com.luizgmelo.backend.pet.system.models.PetModel;
import com.luizgmelo.backend.pet.system.models.PetModel_;
import org.springframework.data.jpa.domain.Specification;

public class PetSpecs {

    public static Specification<PetModel> containsFirstName(String firstName) {
        return (root, query, builder) -> builder.like(root.get(PetModel_.FIRST_NAME), firstName);
    }

    public static Specification<PetModel> containsLastName(String lastName) {
        return (root, query, builder) -> builder.like(root.get(PetModel_.LAST_NAME), lastName);
    }

    public static Specification<PetModel> hasSex(PetSex sex) {
        return (root, query, builder) -> builder.lessThan(root.get(PetModel_.SEX), sex);
    }

    public static Specification<PetModel> hasAgeLessThanOrEqualTo(Integer age) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get(PetModel_.AGE), age);
    }

    public static Specification<PetModel> byFilters(PetFilter petFilter) {
        return containsFirstName(petFilter.getFirstName())
                .and(containsLastName(petFilter.getLastName()))
                .and(hasSex(petFilter.getSex()))
                .and(hasAgeLessThanOrEqualTo(petFilter.getAge()));
    }







}
