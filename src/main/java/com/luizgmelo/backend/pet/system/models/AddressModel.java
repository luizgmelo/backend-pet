package com.luizgmelo.backend.pet.system.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_address")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String street;
    private Integer houseNumber;
    private String city;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pet> pets;
}
