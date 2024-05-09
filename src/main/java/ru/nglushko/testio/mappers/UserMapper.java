package ru.nglushko.testio.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.nglushko.testio.models.dto.VmCreateUser;
import ru.nglushko.testio.models.dto.VmUser;
import ru.nglushko.testio.models.entity.Role;
import ru.nglushko.testio.models.entity.User;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "avatar.id", target = "avatarId")
    VmUser mapToVmUser(User user);

    @Mapping(target = "roles", expression = "java(mapRoles(vmCreateUser.getRole()))")
    User mapToUser(VmCreateUser vmCreateUser);

    default List<Role> mapRoles(String role) {
        List<Role> roles = new ArrayList<>();
        if (role != null) {
            roles.add(Role.valueOf(role));
        }
        return roles;
    }

}
