package com.luizgmelo.backend.pet.system.dto;

import com.luizgmelo.backend.pet.system.models.AddressModel;

import java.util.UUID;

public record AddressDTO(UUID id, String street, Integer houseNumber, String city) {
    public static AddressDTO fromAddress(AddressModel address) {
        return new AddressDTO(address.getId(), address.getStreet(), address.getHouseNumber(), address.getCity());
    }
}
