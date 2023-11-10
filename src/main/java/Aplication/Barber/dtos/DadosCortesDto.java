package Aplication.Barber.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCortesDto(
        @NotBlank(message = "Obrigatorio tipo do corte")
        String tipoCortes,

        @NotNull(message = "Preco Obrigatorio")
        String price) {
}
