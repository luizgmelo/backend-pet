package com.luizgmelo.backend.pet.system.models;

import com.luizgmelo.backend.pet.system.enums.PetType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_pet")
public class PetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;
    private PetType type;
    private Character sex;
    private Integer age;
    private Double weight;
    private String breed;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressModel address;
}
