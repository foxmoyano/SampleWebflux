package cl.foxcorp.woff.samplewebflux.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SaludosService {

    public Mono<String> generarSaludo(int i) {
        int tiempoEspera = ThreadLocalRandom.current().nextInt(1, 6);
        return Mono.just("¡Hola! Espera " + tiempoEspera + " segundos. Soy el index : " + i + "\n")
                .delayElement(Duration.ofSeconds(tiempoEspera));
    }
}
