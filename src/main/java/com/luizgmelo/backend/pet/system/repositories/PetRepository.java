package com.luizgmelo.backend.pet.system.repositories;

import com.luizgmelo.backend.pet.system.enums.PetType;
import com.luizgmelo.backend.pet.system.models.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID>, JpaSpecificationExecutor<Pet> {
    Page<Pet> findAll(Specification<Pet> spec, Pageable pageable);
}
