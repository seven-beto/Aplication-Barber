package Aplication.Barber.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteCadastroDto(
        @NotBlank(message = "Nome do cliente obrigatorio")
        String nome,

        @NotNull(message = "Cpf obrigatorio")
        String cpf,

        @NotNull(message = "Numero do celular obrigatorio")
        String celular) {
}
