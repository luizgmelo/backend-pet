package com.luizgmelo.backend.pet.system.models;

import com.luizgmelo.backend.pet.system.enums.PetSex;
import com.luizgmelo.backend.pet.system.enums.PetType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_pet")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;
    private PetType type;
    private PetSex sex;
    private Integer age;
    private Double weight;
    private String breed;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressModel address;

    @CreatedDate
    private Instant createdAt;
}
