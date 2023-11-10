package Aplication.Barber.controllers;


import Aplication.Barber.domain.Barbeiro;
import Aplication.Barber.dtos.DadosAtualizarBarbeiroDto;
import Aplication.Barber.dtos.DadosBarbeiroDto;
import Aplication.Barber.repository.BarbeiroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barbeiro")
public class BarbeiroController {

    @Autowired
    private BarbeiroRepository repository;

    @GetMapping
    public ResponseEntity all(DadosBarbeiroDto dados){
        var allList = repository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosBarbeiroDto dados){
        var cadastroBarbeiro = repository.save(new Barbeiro(dados));
        return new ResponseEntity<>(cadastroBarbeiro, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(DadosAtualizarBarbeiroDto dados){
        var atualizarBarbeiro = repository.getReferenceById(dados.id());
        atualizarBarbeiro.atualizando(dados);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar (@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
