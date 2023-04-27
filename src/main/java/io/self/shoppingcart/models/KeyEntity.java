package io.self.shoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public interface KeyEntity<T> extends Serializable {
    @JsonIgnore
    public T getKey();
}
