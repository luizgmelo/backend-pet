package com.luizgmelo.backend.pet.system.services;

import com.luizgmelo.backend.pet.system.dto.PetRequestDTO;
import com.luizgmelo.backend.pet.system.models.AddressModel;
import com.luizgmelo.backend.pet.system.models.PetModel;
import com.luizgmelo.backend.pet.system.repositories.AddressRepository;
import com.luizgmelo.backend.pet.system.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final AddressRepository addressRepository;

    public void createPet(PetRequestDTO request) {
        AddressModel address = AddressModel.builder()
                .city(request.city())
                .houseNumber(request.houseNumber())
                .street(request.street())
                .build();

        addressRepository.save(address);

        PetModel newPet = PetModel.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .age(request.age())
                .address(address)
                .sex(request.sex())
                .breed(request.breed())
                .weight(request.weight())
                .type(request.type())
                .build();

        petRepository.save(newPet);
    }

}
