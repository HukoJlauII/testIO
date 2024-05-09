package ru.nglushko.testio.services.impl;

import javax.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.nglushko.testio.mappers.UserMapper;
import ru.nglushko.testio.models.dto.VmCreateUser;
import ru.nglushko.testio.models.dto.VmUpdateUser;
import ru.nglushko.testio.models.dto.VmUser;
import ru.nglushko.testio.models.entity.User;
import ru.nglushko.testio.repositories.UserRepository;
import ru.nglushko.testio.services.UserService;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    @Cacheable(value = "users", key = "#createUser.getUsername()")
    @Transactional(propagation = Propagation.MANDATORY)
    public VmUser createUser(VmCreateUser createUser) {
        User user = userMapper.mapToUser(createUser);
        return userMapper.mapToVmUser(userRepository.save(user));
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    @Cacheable(value = "users", key = "#username")
    public VmUser updateUser(String username, VmUpdateUser user) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "users", key = "#username")
    public VmUser getUser(String username) {
        User user = userRepository.findUserByUsername(username)
            .orElseThrow(() -> new EntityNotFoundException("Пользователя с таким именем не существует"));
        return userMapper.mapToVmUser(user);
    }

}

