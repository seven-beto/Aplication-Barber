package Aplication.Barber.dtos;


import jakarta.validation.constraints.NotBlank;


public record DadosBarbeiroDto(
        @NotBlank(message = "Nome do barbeiro obrigatorio")
        String nome
) {
}
