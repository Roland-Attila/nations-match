package org.fasttrackit.nationsmatch.web;

import org.fasttrackit.nationsmatch.domain.User;
import org.fasttrackit.nationsmatch.service.UserService;
import org.fasttrackit.nationsmatch.transfer.SaveUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/nations-match")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid SaveUserRequest request) {
        User user = userService.createUser(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
