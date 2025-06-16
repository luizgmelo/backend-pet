package com.luizgmelo.backend.pet.system.enums;

public enum PetType {
    DOG("dogs"),
    CAT("cats");

    final String value;

    PetType(String value) {
        this.value = value;
    }

    public static PetType fromValue(String value) {
        for (PetType type : PetType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de pet inválido: " + value);
    }
}
