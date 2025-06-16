package com.luizgmelo.backend.pet.system.controllers;

import com.luizgmelo.backend.pet.system.dto.PetDTO;
import com.luizgmelo.backend.pet.system.dto.PetRequestDTO;
import com.luizgmelo.backend.pet.system.enums.PetSex;
import com.luizgmelo.backend.pet.system.enums.PetType;
import com.luizgmelo.backend.pet.system.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping
    public ResponseEntity<Page<PetDTO>> listPetsByType(@RequestParam(required = true) PetType type,
                                                       @RequestParam(required = false) String firstName,
                                                       @RequestParam(required = false) String lastName,
                                                       @RequestParam(required = false) PetSex sex,
                                                       @RequestParam(required = false) Integer age,
                                                       @RequestParam(required = false) Double weight,
                                                       @RequestParam(required = false) String breed,
                                                       @RequestParam(required = false) String street,
                                                       @RequestParam(required = false) Integer houseNumber,
                                                       @RequestParam(required = false) String city,
                                                       @PageableDefault(size = 12) Pageable pageable) {
        Page<PetDTO> response = petService.listPetsByType(type, firstName, lastName, sex, age, weight, breed, street, houseNumber, city, pageable);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<PetDTO> createPet(@RequestBody PetRequestDTO request) {
        PetDTO petDTO = petService.createPet(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(petDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<PetDTO> updatePet(@PathVariable UUID id, @RequestBody PetRequestDTO request) {
        PetDTO petDTO = petService.updatePet(id, request);
        return ResponseEntity.ok(petDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePet(@PathVariable UUID id) {
        petService.deletePetById(id);
        return ResponseEntity.noContent().build();
    }
}
