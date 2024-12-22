package br.com.bbb.votacao.domain.repository;

import br.com.bbb.votacao.domain.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}
