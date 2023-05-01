package io.self.shoppingcart.services;

import io.self.shoppingcart.models.Cart;
import io.self.shoppingcart.models.CartId;
import io.self.shoppingcart.models.CartItemDTO;
import io.self.shoppingcart.models.Product;
import io.self.shoppingcart.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

  private final CartRepository repository;

  public Page<Product> getCartItems(String name, int page, int size) {
    return repository.getItems(name, PageRequest.of(page, size));
  }

  public Cart addItem(String userName, CartItemDTO cartItem) {
    Cart cart = Cart.builder()
        .userName(userName)
        .productId(cartItem.getId())
        .createdAt(new Date())
        .updatedAt(new Date())
        .quantity(cartItem.getQuantity())
        .build();
    return this.repository.save(cart);
  }

  public Optional<Cart> updateQuantity(String userName, CartItemDTO item) {
    return findById(userName, item.getId()).map(existing -> {
      existing.setQuantity(item.getQuantity());
      return repository.save(existing);
    });
  }

  public Optional<Cart> removeItem(String userName, String productId) {
    Optional<Cart> item = findById(userName, productId);

    if (item.isPresent()) {
      this.repository.delete(item.get());
      return item;
    }
    return Optional.empty();
  }

  public Optional<Cart> findById(String userName, String productId) {
    CartId id = new CartId(userName, productId);
    return this.repository.findById(id);
  }
}
