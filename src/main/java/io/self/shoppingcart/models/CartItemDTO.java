package io.self.shoppingcart.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class CartItemDTO extends Product {

  private int quantity;

  public CartItemDTO(
      String id,
      String category,
      String title,
      String description,
      double price,
      int quantity,
      Date createdAt,
      Date updatedAt
  ) {
      this.id = id;
      this.category = category;
      this.title = title;
      this.description = description;
      this.price = price;
      this.quantity = quantity;
      this.createdAt = createdAt;
      this.updatedAt = updatedAt;
  }

  public CartItemDTO(String productId, int quantity) {
    this.id = productId;
    this.quantity = quantity;
  }
}
