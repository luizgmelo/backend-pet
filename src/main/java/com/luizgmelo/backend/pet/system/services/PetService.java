package com.luizgmelo.backend.pet.system.services;

import com.luizgmelo.backend.pet.system.dto.PetDTO;
import com.luizgmelo.backend.pet.system.dto.PetRequestDTO;
import com.luizgmelo.backend.pet.system.enums.PetType;
import com.luizgmelo.backend.pet.system.models.AddressModel;
import com.luizgmelo.backend.pet.system.models.Pet;
import com.luizgmelo.backend.pet.system.repositories.AddressRepository;
import com.luizgmelo.backend.pet.system.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
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

    public Pet getPetById(UUID id) {
        return petRepository.findById(id).orElseThrow();
    }

    public Page<PetDTO> listPetsByType(PetType petType, Pageable pageable) {
        return petRepository.findAllByType(petType, pageable).map(PetDTO::fromPet);
    }

    public Page<PetDTO> listPest(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return petRepository.findAll(pageable).map(PetDTO::fromPet);
    }
    public PetDTO createPet(PetRequestDTO request) {
        AddressModel address = AddressModel.builder().city(request.city()).houseNumber(request.houseNumber())
                .street(request.street()).build();

        addressRepository.save(address);

        Pet newPet = Pet.builder().firstName(request.firstName()).lastName(request.lastName())
                .age(request.age()).address(address).sex(request.sex()).breed(request.breed()).weight(request.weight())
                .type(request.type()).build();

        Pet savedPet = petRepository.save(newPet);

        return PetDTO.fromPet(savedPet);
    }

    public PetDTO updatePet(UUID petOldId, PetRequestDTO dto) {
        Pet petOld = this.getPetById(petOldId);

        AddressModel addressModel = new AddressModel();
        addressModel.setCity(dto.city());
        addressModel.setHouseNumber(dto.houseNumber());
        addressModel.setStreet(dto.street());

        petOld.setFirstName(dto.firstName());
        petOld.setLastName(dto.lastName());
        petOld.setType(dto.type());
        petOld.setSex(dto.sex());
        petOld.setAddress(addressModel);
        petOld.setAge(dto.age());
        petOld.setWeight(dto.weight());
        petOld.setBreed(dto.breed());

        addressRepository.save(addressModel);
        petRepository.save(petOld);

        return PetDTO.fromPet(petOld);
    }

    public void deletePetById(UUID id) {
        petRepository.deleteById(id);
    }

}
