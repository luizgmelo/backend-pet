package com.luizgmelo.backend.pet.system.controllers;

import com.luizgmelo.backend.pet.system.dto.PetRequestDTO;
import com.luizgmelo.backend.pet.system.models.AddressModel;
import com.luizgmelo.backend.pet.system.models.PetModel;
import com.luizgmelo.backend.pet.system.repositories.AddressRepository;
import com.luizgmelo.backend.pet.system.repositories.PetRepository;
import com.luizgmelo.backend.pet.system.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping
    public ResponseEntity<Page<PetModel>> listPets(@RequestParam(defaultValue = "0") int pageNo,
                                     @RequestParam(defaultValue = "10") int pageSize) {
        Page<PetModel> pagePets = petService.listPest(pageNo, pageSize);
        return ResponseEntity.ok(pagePets);
    }

    @PostMapping
    public ResponseEntity<String> createPet(@RequestBody PetRequestDTO request) {
        petService.createPet(request);
        return ResponseEntity.ok("Pet cadastrado com sucesso!");
    }


}
