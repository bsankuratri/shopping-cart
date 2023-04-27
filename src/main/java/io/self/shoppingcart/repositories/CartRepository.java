package io.self.shoppingcart.repositories;

import io.self.shoppingcart.models.Cart;
import io.self.shoppingcart.models.CartId;
import io.self.shoppingcart.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, CartId> {

  @Query(
      "SELECT new io.self.shoppingcart.models.CartItemDTO(" +
          "p.id, p.category, p.title, p.description, p.price, c.quantity, c.createdAt, c.updatedAt " +
      ") FROM Product p INNER JOIN Cart c ON p.id=c.productId WHERE c.userName = :userName"

//      "SELECT new io.self.shoppingcart.models.CartItemDTO(" +
//      "id, category, title, description, price, createdAt, updatedAt, quantity) FROM " +
//      "(SELECT p.id AS id, p.category AS category, p.title AS title, p.description AS description, " +
//      "p.price AS price, p.createdAt AS createdAt, p.updatedAt AS updatedAt, c.quantity AS quantity" +
//      " FROM FROM Product p INNER JOIN Cart c ON p.id=c.productId WHERE c.userName = :userName)"
  )
  public Page<Product> getItems(@Param("userName") String userName, Pageable pageable);
}
