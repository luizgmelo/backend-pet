package com.luizgmelo.backend.pet.system.controllers;

import com.luizgmelo.backend.pet.system.dto.PetDTO;
import com.luizgmelo.backend.pet.system.dto.PetRequestDTO;
import com.luizgmelo.backend.pet.system.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> createPet(@RequestBody PetRequestDTO request) {
        petService.createPet(request);
        return ResponseEntity.ok("Pet cadastrado com sucesso!");
    }


}
