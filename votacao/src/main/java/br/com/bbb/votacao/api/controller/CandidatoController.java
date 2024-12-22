package br.com.bbb.votacao.api.controller;

import br.com.bbb.votacao.api.dto.CandidatoDTO;
import br.com.bbb.votacao.domain.model.Candidato;
import br.com.bbb.votacao.domain.repository.CandidatoRepository;
import br.com.bbb.votacao.domain.service.CandidatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("candidatos")
@AllArgsConstructor
public class CandidatoController {
    private CandidatoService candidatoService;

    @PostMapping
    public ResponseEntity<Candidato> persistirCandidato(@RequestBody CandidatoDTO dto){
        return candidatoService.persistirCandidato(dto);
    }
}
