package io.self.shoppingcart.services;

import io.self.shoppingcart.models.User;
import io.self.shoppingcart.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Page<User> getUsersPage(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Optional<User> findByName(String name) {
        return repository.findById(name);
    }
}
