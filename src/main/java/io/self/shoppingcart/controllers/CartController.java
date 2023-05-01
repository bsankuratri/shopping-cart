package io.self.shoppingcart.controllers;

import io.self.shoppingcart.models.Cart;
import io.self.shoppingcart.models.CartItemDTO;
import io.self.shoppingcart.models.Product;
import io.self.shoppingcart.models.ProductFilter;
import io.self.shoppingcart.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("users/{name}/cart")
@RequiredArgsConstructor
@Validated
public class CartController {

  private final CartService service;
  @GetMapping()
  public ResponseEntity<Page<Product>> getCartItems(
      @PathVariable() String name,
      @Valid @Min(0) @RequestParam(defaultValue = "0", required = false) int page,
      @Valid @Max(200) @RequestParam(defaultValue = "25", required = false) int size
  ) {
    return ResponseEntity.ok(service.getCartItems(name, page, size));
  }

  @PostMapping()
  public ResponseEntity<Cart> addItem(
      @PathVariable() String name,
      @RequestBody CartItemDTO item
  ) {
    return ResponseEntity.ok(service.addItem(name, item));
  }

  @PutMapping()
  public ResponseEntity<Cart> updateQuantity(@PathVariable() String name, @RequestBody CartItemDTO item) {
    return ResponseEntity.of(service.updateQuantity(name, item));
  }

  @DeleteMapping("{productId}")
  public ResponseEntity<Cart> removeItem(@PathVariable() String name, @PathVariable() String productId) {
    return ResponseEntity.of(service.removeItem(name, productId));
  }
}
