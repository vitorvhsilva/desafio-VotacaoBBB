package br.com.bbb.votacao.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Voto {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Candidato candidato;
    private LocalDateTime dataVoto;

    @Override
    public String toString() {
        return "Voto computado para o candidato " + candidato.getNome();
    }
}
