package Aplication.Barber.domain;


import Aplication.Barber.dtos.DadosCortesDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Table(name = "cortes")
@Entity(name = "Cortes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Cortes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tipoCortes;

    private String price;

    public Cortes(DadosCortesDto dados) {
        this.tipoCortes = dados.tipoCortes();
        this.price = dados.price();
    }
}
