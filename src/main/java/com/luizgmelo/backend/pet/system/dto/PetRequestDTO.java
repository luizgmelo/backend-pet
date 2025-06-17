package com.luizgmelo.backend.pet.system.dto;

import com.luizgmelo.backend.pet.system.enums.PetSex;
import com.luizgmelo.backend.pet.system.enums.PetType;
import jakarta.validation.constraints.*;

public record PetRequestDTO(@NotBlank(message = "Nome é obrigatório")
                            @Pattern(message = "Nome não pode conter números" , regexp = "^[^0-9]*")
                            String firstName,

                            @NotBlank(message = "Sobrenome é obrigatório")
                            @Pattern(message = "Sobrenome não pode conter números" , regexp = "^[^0-9]*")
                            String lastName,

                            PetType type,

                            PetSex sex,

                            String street,

                            Integer houseNumber,

                            String city,

                            @DecimalMin(value = "0", message = "A idade não pode ser menor que 0 anos")
                            @DecimalMax(value = "20", message = "A idade não pode ser maior que 20 anos")
                            Integer age,

                            @DecimalMin(value = "0.5", message = "O peso não pode ser menor que 0.5kg")
                            @DecimalMax(value = "60.0", message = "O peso não pode ser maior que 60.0kg")
                            Double weight,

                            @Pattern(message = "Raça só pode conter letras e números" , regexp = "^[ a-zA-Z0-9]*")
                            String breed) {
}
