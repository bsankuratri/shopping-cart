package io.self.shoppingcart.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductFilter {

    private List<String> categories;

    private Range price;
}
