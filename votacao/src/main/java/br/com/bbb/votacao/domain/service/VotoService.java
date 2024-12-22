package br.com.bbb.votacao.domain.service;

import br.com.bbb.votacao.api.dto.VotoDTO;
import br.com.bbb.votacao.domain.model.Candidato;
import br.com.bbb.votacao.domain.model.Voto;
import br.com.bbb.votacao.domain.repository.CandidatoRepository;
import br.com.bbb.votacao.domain.repository.VotoRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class VotoService {

    private RabbitTemplate rabbitTemplate;
    private VotoRepository votoRepository;
    private CandidatoRepository candidatoRepository;

    public ResponseEntity<Void> processarVoto(VotoDTO dto) {
        rabbitTemplate.convertAndSend("computar.voto.queue", dto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public void computarVoto(VotoDTO dto) {
        Candidato candidato = candidatoRepository.findById(dto.getIdCandidato())
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado!"));
        Voto voto = votoRepository.save(new Voto(null, candidato, LocalDateTime.now()));
        System.out.println("Voto computado: " + voto);
    }
}
