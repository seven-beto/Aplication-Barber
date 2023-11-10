package Aplication.Barber.repository;

import Aplication.Barber.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    public List<Agendamento> FindBydataAgendamento(LocalDateTime dataAgendamento);
}
