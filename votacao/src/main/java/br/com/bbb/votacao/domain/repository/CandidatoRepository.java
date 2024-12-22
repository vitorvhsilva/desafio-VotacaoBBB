package br.com.bbb.votacao.domain.repository;

import br.com.bbb.votacao.domain.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
