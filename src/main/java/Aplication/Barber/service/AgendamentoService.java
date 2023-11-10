package Aplication.Barber.service;


import Aplication.Barber.domain.Agendamento;
import Aplication.Barber.domain.Barbeiro;
import Aplication.Barber.domain.Cliente;
import Aplication.Barber.domain.Cortes;
import Aplication.Barber.dtos.DadosAgendamentoDto;
import Aplication.Barber.repository.AgendamentoRepository;
import Aplication.Barber.repository.BarbeiroRepository;
import Aplication.Barber.repository.ClienteRepository;
import Aplication.Barber.repository.CortesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CortesRepository cortesRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento agendar (DadosAgendamentoDto dados){
        Barbeiro barbeiro = barbeiroRepository.findById(dados.idBarbeiro()).get();
        Cliente cliente = clienteRepository.findById(dados.IdCliente()).get();
        Cortes cortes = cortesRepository.findById(dados.idCortes()).get();
        Agendamento agendamento = new Agendamento();
        agendamento.setIdBarbeiro(barbeiro);
        agendamento.setIdCliente(cliente);
        agendamento.setIdCortes(cortes);

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento>FindBydataAgendamento(LocalDateTime dataAgendamento){
        return agendamentoRepository.FindBydataAgendamento(dataAgendamento);
    }

}
