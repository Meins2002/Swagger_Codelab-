package org.adaschool.api.controller;

import org.adaschool.api.repository.product.Product;
import org.adaschool.api.repository.user.User;
import org.adaschool.api.repository.user.UserDto;
import org.adaschool.api.service.product.ProductsService;
import org.adaschool.api.service.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/health")
public class HealthController {

    private final UsersService usersService;
    public HealthController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User newUser =usersService.save(new User(userDto));
        URI createdProductUri = URI.create("");
        return ResponseEntity.created(createdProductUri).body(userDto);
    }


}
