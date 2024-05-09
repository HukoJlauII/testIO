package ru.nglushko.testio.models.dto;

import java.time.LocalDate;

import lombok.Data;


@Data
public class VmUser {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String name;

    private String surname;

    private LocalDate registrationDate;

    private Long avatarId;

}
