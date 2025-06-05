package com.luizgmelo.backend.pet.system.controllers;

import com.luizgmelo.backend.pet.system.dto.PetRequestDTO;
import com.luizgmelo.backend.pet.system.models.AddressModel;
import com.luizgmelo.backend.pet.system.models.PetModel;
import com.luizgmelo.backend.pet.system.repositories.AddressRepository;
import com.luizgmelo.backend.pet.system.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetRepository petRepository;
    private final AddressRepository addressRepository;

    @PostMapping
    public ResponseEntity<String> createPet(@RequestBody PetRequestDTO request) {

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

        return ResponseEntity.status(HttpStatus.OK).body("Pet cadastrado com sucesso!");
    }


}
