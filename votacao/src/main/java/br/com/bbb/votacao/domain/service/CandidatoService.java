package br.com.bbb.votacao.domain.service;

import br.com.bbb.votacao.api.dto.CandidatoDTO;
import br.com.bbb.votacao.domain.model.Candidato;
import br.com.bbb.votacao.domain.repository.CandidatoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidatoService {
    private CandidatoRepository candidatoRepository;
    private ModelMapper modelMapper;

    public ResponseEntity<Candidato> persistirCandidato(CandidatoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoRepository.save(modelMapper.map(dto, Candidato.class)));
    }
}
