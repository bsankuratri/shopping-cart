package io.self.shoppingcart.controllers;

import io.self.shoppingcart.models.User;
import io.self.shoppingcart.services.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping()
    public ResponseEntity<Page<User>> getUsersPage(
            @Min(0) @RequestParam(defaultValue = "0", required = false) int page,
            @Max(200) @RequestParam(defaultValue = "25", required = false) int size
    ) {
        return ResponseEntity.ok(service.getUsersPage(page, size));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable String name) {
        return service.findByName(name).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
