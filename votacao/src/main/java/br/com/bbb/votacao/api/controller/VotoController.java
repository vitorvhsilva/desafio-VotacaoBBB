package br.com.bbb.votacao.api.controller;

import br.com.bbb.votacao.api.dto.VotoDTO;
import br.com.bbb.votacao.domain.service.VotoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("votos")
@AllArgsConstructor
public class VotoController {

    private VotoService votoService;

    @PostMapping
    public ResponseEntity<Void> processarVoto(@RequestBody VotoDTO dto) {
        return votoService.processarVoto(dto);
    }
}
