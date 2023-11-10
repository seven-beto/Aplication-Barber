package Aplication.Barber.domain;

import Aplication.Barber.dtos.DadosAtualizarBarbeiroDto;
import Aplication.Barber.dtos.DadosBarbeiroDto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "barbeiro")
@Entity(name = "Barbeiro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Barbeiro(DadosBarbeiroDto dados) {
        this.nome = dados.nome();
    }

    public void atualizando(DadosAtualizarBarbeiroDto dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
    }
}
