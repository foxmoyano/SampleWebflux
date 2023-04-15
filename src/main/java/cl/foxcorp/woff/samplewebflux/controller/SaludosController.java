package cl.foxcorp.woff.samplewebflux.controller;

import cl.foxcorp.woff.samplewebflux.dto.PersonDTO;
import cl.foxcorp.woff.samplewebflux.service.SaludosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class SaludosController {

    @Autowired
    private SaludosService saludosService;

    @GetMapping("/getSaludos")
    public Flux<String> getSaludos() {
        Flux<String> saludos = Flux.range(1, 10)
                .parallel()
                .flatMap(i -> saludosService.generarSaludo(i))
                .ordered((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .log();
        return saludos;
    }
    @GetMapping("/saludos")
    public Flux<String> saludos() {
        return Flux.just("Hola", "Bonjour", "Hello", "Ciao", "こんにちは");
    }
}
