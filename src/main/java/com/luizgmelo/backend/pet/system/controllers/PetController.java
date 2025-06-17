package com.luizgmelo.backend.pet.system.controllers;

import com.luizgmelo.backend.pet.system.dto.PetDTO;
import com.luizgmelo.backend.pet.system.dto.PetFilterDto;
import com.luizgmelo.backend.pet.system.dto.PetRequestDTO;
import com.luizgmelo.backend.pet.system.enums.PetType;
import com.luizgmelo.backend.pet.system.services.PetService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Page<PetDTO>> listPets(@PageableDefault(size = 12) Pageable pageable) {
        Page<PetDTO> response = petService.listPets(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{type}")
    public ResponseEntity<Page<PetDTO>> listPetsByType(@PathVariable PetType type,
                                                       @ModelAttribute PetFilterDto petFilterDto,
                                                       @PageableDefault(size = 12) Pageable pageable) {
        Page<PetDTO> response = petService.listPetByFilters(type, petFilterDto, pageable);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<PetDTO> createPet(@Valid @RequestBody PetRequestDTO request) {
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
