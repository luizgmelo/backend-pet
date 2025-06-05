package com.luizgmelo.backend.pet.system.controllers;

import com.luizgmelo.backend.pet.system.dto.PetDTO;
import com.luizgmelo.backend.pet.system.dto.PetRequestDTO;
import com.luizgmelo.backend.pet.system.models.PetModel;
import com.luizgmelo.backend.pet.system.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<PetDTO>> listPets(@RequestParam(defaultValue = "0") int pageNo,
                                     @RequestParam(defaultValue = "10") int pageSize) {
        Page<PetDTO> pagePets = petService.listPest(pageNo, pageSize);
        return ResponseEntity.ok(pagePets);
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
