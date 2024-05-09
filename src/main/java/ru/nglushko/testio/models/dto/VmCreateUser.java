package ru.nglushko.testio.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class VmCreateUser {

    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 3,message = "Минимальная длина никнейма - 3 символа")
    private String username;

    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 8,message = "Минимальная длина пароля - 8 символов")
    private String password;

    @NotBlank(message = "Поле не может быть пустым")
    private String passwordConfirm;

    @NotBlank(message = "Поле не может быть пустым")
    @Email(message = "Поле должно быть в формате электронной почты")
    private String email;

    @NotBlank(message = "Поле не может быть пустым")
    private String name;

    @NotBlank(message = "Поле не может быть пустым")
    private String surname;

    private String role;
}
