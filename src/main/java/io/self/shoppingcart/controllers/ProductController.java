package io.self.shoppingcart.controllers;

import io.self.shoppingcart.models.Product;
import io.self.shoppingcart.models.ProductFilter;
import io.self.shoppingcart.services.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService service;

    @PostMapping()
    public ResponseEntity<Page<Product>> getUsersPage(
            @Valid @Min(0) @RequestParam(defaultValue = "0", required = false) int page,
            @Valid @Max(200) @RequestParam(defaultValue = "25", required = false) int size,
            @RequestBody ProductFilter filter
    ) {
        return ResponseEntity.ok(service.getProductsPage(page, size, filter));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable String name) {
        return service.findByName(name).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
