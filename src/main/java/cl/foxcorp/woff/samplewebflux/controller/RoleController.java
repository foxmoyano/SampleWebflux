package cl.foxcorp.woff.samplewebflux.controller;

import cl.foxcorp.woff.samplewebflux.dto.RoleDTO;
import cl.foxcorp.woff.samplewebflux.service.RoleService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public Flux<RoleDTO> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<RoleDTO> findById(@PathVariable String id) {
        return roleService.findById(id);
    }

    @PostMapping
    public Mono<RoleDTO> save(@RequestBody RoleDTO roleDto) {
        return roleService.save(roleDto);
    }

    @PutMapping("/{id}")
    public Mono<RoleDTO> update(@PathVariable String id, @RequestBody RoleDTO roleDto) {
        return roleService.update(id, roleDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        return roleService.deleteById(id);
    }
}