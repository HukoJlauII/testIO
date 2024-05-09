package ru.nglushko.testio.controllers.rest;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nglushko.testio.configuration.PathConstants;
import ru.nglushko.testio.models.dto.VmCreateUser;
import ru.nglushko.testio.models.dto.VmUpdateUser;
import ru.nglushko.testio.models.dto.VmUser;
import ru.nglushko.testio.services.UserService;


@RestController
@RequestMapping(PathConstants.API_V1 + PathConstants.USERS)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<VmUser> getUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUser(username));
    }

    @PostMapping
    public ResponseEntity<VmUser> createUser(@Valid @RequestBody VmCreateUser createUser) {
        return new ResponseEntity<>(userService.createUser(createUser), HttpStatus.CREATED);
    }

    @PatchMapping("/{username}")
    public ResponseEntity<VmUser> getUser(@PathVariable String username,@Valid @RequestBody VmUpdateUser updateUser) {
        return ResponseEntity.ok(userService.updateUser(username,updateUser));
    }

}
