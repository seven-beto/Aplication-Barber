package Aplication.Barber.domain;


import Aplication.Barber.dtos.ClienteAtualizarDto;
import Aplication.Barber.dtos.ClienteCadastroDto;
import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String celular;

    public Cliente(ClienteCadastroDto dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.celular = dados.celular();
    }

    public void atualizando(ClienteAtualizarDto dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.cpf() != null){
            this.cpf = dados.cpf();
        }
        if(dados.celular() != null){
            this.celular = dados.celular();
        }
    }
}
