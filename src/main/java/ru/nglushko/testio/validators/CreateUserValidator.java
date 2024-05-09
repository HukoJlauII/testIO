package ru.nglushko.testio.validators;

import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.nglushko.testio.models.dto.VmCreateUser;
import ru.nglushko.testio.repositories.UserRepository;


@Component
@RequiredArgsConstructor
public class CreateUserValidator implements Validator {

    private final UserRepository userRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return VmCreateUser.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        VmCreateUser validationTarget = (VmCreateUser) target;
        if (!Objects.equals(validationTarget.getPassword(), validationTarget.getPasswordConfirm())) {
            errors.reject("passwordConfirm", "Пароли не совпадают");
        }
        if (userRepository.findUserByUsername(validationTarget.getUsername()).isPresent()){
            errors.reject("username", "Пользователь с таким именем уже существует");
        }

        if (userRepository.findUserByEmail(validationTarget.getUsername()).isPresent()){
            errors.reject("email", "Пользователь с таким именем уже существует");
        }

    }

}
