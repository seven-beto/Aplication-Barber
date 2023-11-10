package Aplication.Barber.controllers;


import Aplication.Barber.domain.Agendamento;
import Aplication.Barber.dtos.DadosAgendamentoDto;
import Aplication.Barber.repository.AgendamentoRepository;
import Aplication.Barber.service.AgendamentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @Autowired
    private AgendamentoRepository agendamentoRepository;


    @GetMapping
    private ResponseEntity all(DadosAgendamentoDto dados){
        var findAll =  agendamentoRepository.findAll();
        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastro (@RequestBody @Valid DadosAgendamentoDto dados){
        var agendamento = service.agendar(dados);
        return new ResponseEntity<>(agendamento, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity FindBydata(@RequestParam LocalDateTime dataAgendamento){
        var find = service.FindBydataAgendamento(dataAgendamento);
        return new ResponseEntity<>(find, HttpStatus.OK);
    }

}
