package cl.foxcorp.woff.samplewebflux.mapper;

import cl.foxcorp.woff.samplewebflux.dto.RoleDTO;
import cl.foxcorp.woff.samplewebflux.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface RoleMapper {
    RoleDTO roleToRoleDto(Role entity);
    Role roleDtoToRole(RoleDTO dto);
    @Mapping(target = "id", ignore = true)
    Role updateRolFromRolDto(RoleDTO dto, @MappingTarget Role entity);

}
