package io.self.shoppingcart.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cart", schema = "ecommerce")
@IdClass(CartId.class)
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements KeyEntity<String> {

    @Id
    @Column(name = "user_name")
    private String userName;

    @Id
    @Column(name = "product_id")
    private String productId;

    private int quantity;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public String getKey() {
        return String.format("%s-%s", userName, productId);
    }
}
