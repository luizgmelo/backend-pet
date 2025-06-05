package com.luizgmelo.backend.pet.system.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.luizgmelo.backend.pet.system.dto.PetDTO;
import com.luizgmelo.backend.pet.system.dto.PetRequestDTO;
import com.luizgmelo.backend.pet.system.models.AddressModel;
import com.luizgmelo.backend.pet.system.models.PetModel;
import com.luizgmelo.backend.pet.system.repositories.AddressRepository;
import com.luizgmelo.backend.pet.system.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final AddressRepository addressRepository;

    public PetDTO getPetById(UUID id) {
        return petRepository.findById(id).map(PetDTO::fromPet).orElse(null);
    }

    public Page<PetDTO> listPest(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return petRepository.findAll(pageable).map(PetDTO::fromPet);
    }
    public PetDTO createPet(PetRequestDTO request) {
        AddressModel address = AddressModel.builder().city(request.city()).houseNumber(request.houseNumber())
                .street(request.street()).build();

        addressRepository.save(address);

        PetModel newPet = PetModel.builder().firstName(request.firstName()).lastName(request.lastName())
                .age(request.age()).address(address).sex(request.sex()).breed(request.breed()).weight(request.weight())
                .type(request.type()).build();

        PetModel savedPet = petRepository.save(newPet);

        return PetDTO.fromPet(savedPet);
    }

    public PetDTO updatePet(PetDTO petToUpdate, PetRequestDTO requestDTO) {
        PetModel updatedPet = new PetModel();
        BeanUtils.copyProperties(petToUpdate, updatedPet);
        BeanUtils.copyProperties(requestDTO, petToUpdate);
        PetModel updatedPet = petRepository.save(updatedPet);
        return
    }

    public void deletePetById(UUID id) {
        petRepository.deleteById(id);
    }

}
