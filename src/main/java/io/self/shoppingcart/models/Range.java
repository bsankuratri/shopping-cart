package io.self.shoppingcart.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Builder
public class Range {

    private Double min;

    private Double max;

    public boolean hasFullRange() {
        return Objects.nonNull(min) && Objects.nonNull(max);
    }
}
