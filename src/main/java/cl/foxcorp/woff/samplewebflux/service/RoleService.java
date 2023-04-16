package cl.foxcorp.woff.samplewebflux.service;

import cl.foxcorp.woff.samplewebflux.dto.RoleDTO;
import cl.foxcorp.woff.samplewebflux.entity.Role;
import cl.foxcorp.woff.samplewebflux.helper.CommonHelper;
import cl.foxcorp.woff.samplewebflux.mapper.RoleMapper;
import cl.foxcorp.woff.samplewebflux.repository.RoleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    private final CommonHelper commonHelper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper, CommonHelper commonHelper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.commonHelper = commonHelper;
    }

    public Flux<RoleDTO> findAll() {
        return roleRepository.findAll()
                .map(roleMapper::roleToRoleDto);
    }

    public Mono<RoleDTO> findById(String id) {
        return roleRepository.findById(id)
                .map(roleMapper::roleToRoleDto);
    }

    public Mono<RoleDTO> save(RoleDTO roleDto) {
        LocalDateTime currentDate = this.commonHelper.getCurrentDate();
        Role role = this.roleMapper.roleDtoToRole(roleDto);
        role.setDateCreation(currentDate);
        role.setValid(true);
        return roleRepository.save(role)
                .map(roleMapper::roleToRoleDto);
    }

    public Mono<RoleDTO> update(String id, RoleDTO roleDto) {
        return roleRepository.findById(id)
                .flatMap(role -> {
                    roleMapper.updateRolFromRolDto(roleDto, role);
                    return roleRepository.save(role)
                            .map(roleMapper::roleToRoleDto);
                });
    }

    public Mono<Void> deleteById(String id) {
        return roleRepository.deleteById(id);
    }
}