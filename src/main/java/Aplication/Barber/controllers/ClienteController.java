package Aplication.Barber.controllers;


import Aplication.Barber.domain.Cliente;
import Aplication.Barber.dtos.ClienteAtualizarDto;
import Aplication.Barber.dtos.ClienteCadastroDto;
import Aplication.Barber.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    private ResponseEntity all(ClienteCadastroDto dados){
        var allList =  repository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastro (@RequestBody @Valid ClienteCadastroDto dados){
        var cadastroCliente = repository.save(new Cliente(dados));
        return new ResponseEntity<>(cadastroCliente, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar (@RequestBody ClienteAtualizarDto dados){
        var atualizarCliente = repository.getReferenceById(dados.id());
        atualizarCliente.atualizando(dados);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
