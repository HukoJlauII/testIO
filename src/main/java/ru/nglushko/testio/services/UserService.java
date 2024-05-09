package ru.nglushko.testio.services;

import ru.nglushko.testio.models.dto.VmCreateUser;
import ru.nglushko.testio.models.dto.VmUpdateUser;
import ru.nglushko.testio.models.dto.VmUser;


public interface UserService {

    VmUser createUser(VmCreateUser createUser);

    VmUser updateUser(String username, VmUpdateUser user);

    VmUser getUser(String username);
    
}
