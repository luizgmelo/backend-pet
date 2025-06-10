package com.luizgmelo.backend.pet.system.repositories;

import com.luizgmelo.backend.pet.system.models.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<PetModel, UUID>, JpaSpecificationExecutor<PetModel> {
}
