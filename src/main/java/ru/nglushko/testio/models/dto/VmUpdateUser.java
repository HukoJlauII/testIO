package ru.nglushko.testio.models.dto;

import lombok.Data;


@Data
public class VmUpdateUser {

    private String username;

    private String email;

    private String name;

    private String surname;
}
