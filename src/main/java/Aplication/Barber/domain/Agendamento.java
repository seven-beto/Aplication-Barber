package Aplication.Barber.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "agendamento")
@Entity(name = "Agendamento")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "idBarbeiro")
    @ManyToOne
    private Barbeiro idBarbeiro;

    @JoinColumn(name = "idCliente")
    @ManyToOne
    private Cliente idCliente;

    @JoinColumn(name = "idBarbeiro")
    @ManyToOne
    private Cortes idCortes;

    @Column(unique = true)
    private LocalDateTime dataAgendamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Barbeiro getIdBarbeiro() {
        return idBarbeiro;
    }

    public void setIdBarbeiro(Barbeiro idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Cortes getIdCortes() {
        return idCortes;
    }

    public void setIdCortes(Cortes idCortes) {
        this.idCortes = idCortes;
    }
}
