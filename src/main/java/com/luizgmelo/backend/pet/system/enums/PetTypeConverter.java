package com.luizgmelo.backend.pet.system.enums;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PetTypeConverter implements Converter<String, PetType> {
    @Override
    public PetType convert(String value) {
        return PetType.fromValue(value);
    }
}
