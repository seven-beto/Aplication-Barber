package Aplication.Barber.controllers;


import Aplication.Barber.domain.Cortes;
import Aplication.Barber.dtos.DadosCortesDto;
import Aplication.Barber.repository.CortesRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cortes")
public class CortesController {

    @Autowired
    private CortesRepository repository;

    @GetMapping
    public ResponseEntity all(DadosCortesDto dados){
        var allList = repository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCortesDto dados){
        var cadastroCortes = repository.save(new Cortes(dados));
        return new ResponseEntity<>(cadastroCortes, HttpStatus.CREATED);
    }
}
