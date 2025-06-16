package com.luizgmelo.backend.pet.system.repositories;

import com.luizgmelo.backend.pet.system.enums.PetSex;
import com.luizgmelo.backend.pet.system.enums.PetType;
import com.luizgmelo.backend.pet.system.models.AddressModel;
import com.luizgmelo.backend.pet.system.models.AddressModel_;
import com.luizgmelo.backend.pet.system.models.Pet;
import com.luizgmelo.backend.pet.system.models.Pet_;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

public class PetSpec {

    public static Specification<Pet> isPetType(PetType type) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(type)) {
                return null;
            }
            return builder.equal(root.get(Pet_.type), type);
        };
    }

    public static Specification<Pet> hasFirstName(String firstName) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(firstName)) {
                return null;
            }
            return builder.like(builder.lower(root.get(Pet_.FIRST_NAME)), "%" + firstName.toLowerCase() + "%");
        };
    }

    public static Specification<Pet> hasLastName(String lastName) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(lastName)) {
                return null;
            }
            return builder.like(builder.lower(root.get(Pet_.LAST_NAME)), "%" + lastName.toLowerCase() + "%");
        };
    }

    public static Specification<Pet> isPetSex(PetSex sex) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(sex)) {
                return null;
            }
            return builder.equal(root.get(Pet_.SEX), sex);
        };
    }

    public static Specification<Pet> ageEqualTo(Integer age) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(age)) {
                return null;
            }
            return builder.equal(root.get(Pet_.AGE), age);
        };
    }

    public static Specification<Pet> weightInRangePlusOne(Double weight) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(weight)) {
                return null;
            }
            Double minWeight = weight;
            Double maxWeight = weight + 1;
            return builder.between(root.get(Pet_.WEIGHT), minWeight, maxWeight);
        };
    }

    public static Specification<Pet> isPetBreed(String breed) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(breed)) {
                return null;
            }
            return builder.equal(root.get(Pet_.BREED), breed);
        };
    }

    public static Specification<Pet> hasStreet(String street) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(street)) {
                return null;
            }
            Join<Pet, AddressModel> addressJoin = root.join(Pet_.ADDRESS);
            return builder.like(builder.lower(addressJoin.get(AddressModel_.STREET)), "%" + street.toLowerCase() + "%");
        };
    }

    public static Specification<Pet> hasCity(String city) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(city)) {
                return null;
            }
            Join<Pet, AddressModel> addressJoin = root.join(Pet_.ADDRESS);
            return builder.equal(addressJoin.get(AddressModel_.CITY), city);
        };
    }

    public static Specification<Pet> hasHouseNumber(Integer houseNumber) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(houseNumber)) {
                return null;
            }
            Join<Pet, AddressModel> addressJoin = root.join(Pet_.ADDRESS);
            return builder.equal(addressJoin.get(AddressModel_.HOUSE_NUMBER), houseNumber);
        };
    }

}
