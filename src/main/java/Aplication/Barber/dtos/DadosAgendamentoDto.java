package Aplication.Barber.dtos;

import java.time.LocalDateTime;

public record DadosAgendamentoDto(Long id, Long idBarbeiro, Long IdCliente, Long idCortes, LocalDateTime dataAgendamento) {
}
