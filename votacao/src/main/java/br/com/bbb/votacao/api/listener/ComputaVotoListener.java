package br.com.bbb.votacao.api.listener;

import br.com.bbb.votacao.api.dto.VotoDTO;
import br.com.bbb.votacao.domain.service.VotoService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ComputaVotoListener {

    private VotoService votoService;

    @RabbitListener(queues = "computar.voto.queue")
    public void computarVoto(@Payload VotoDTO dto) {
        votoService.computarVoto(dto);
    }
}
