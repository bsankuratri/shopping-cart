package io.self.shoppingcart.services;

import io.self.shoppingcart.models.Product;
import io.self.shoppingcart.models.ProductFilter;
import io.self.shoppingcart.models.Range;
import io.self.shoppingcart.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.criteria.Predicate;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Page<Product> getProductsPage(int page, int size, ProductFilter filter) {

        return repository.findAll(
            getCategories(filter.getCategories()).and(getRangeQuery(filter.getPrice())),
            PageRequest.of(page, size)
        );

//        repository.findAll((product, query, builder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//            if (Objects.nonNull(filter.getCategories())) {
//                predicates.add(product.get("category").in(filter.getCategories()));
//            }
//
//            getRangeQuery(Range.builder().build())
//
//            if (Objects.nonNull(filter.getRange()))
//        })
//        return repository.findAll(PageRequest.of(page, size));
    }

    public Specification<Product> getCategories(List<String> categories) {
        return (product, query, builder) -> {
            if (Objects.isNull(categories)) {
                return builder.isTrue(builder.literal(true));
            }
            return product.get("category").in(categories);
        };
    }


    public Specification<Product> getRangeQuery(Range range) {
        return (product, query, builder) -> {
            if (Objects.isNull(range)) {
                return builder.isTrue(builder.literal(true));
            }
            if (range.hasFullRange()) {
                return builder.between(product.get("price"), range.getMin(), range.getMax());
            } else if (Objects.nonNull(range.getMin())) {
                return builder.greaterThanOrEqualTo(product.get("price"), range.getMin());
            } else {
                return builder.lessThanOrEqualTo(product.get("price"), range.getMax());
            }
        };
    }

    public Optional<Product> findByName(String name) {
        return repository.findById(name);
    }
}
