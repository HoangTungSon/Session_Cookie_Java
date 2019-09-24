package source.service;

import source.model.Cart;
import source.model.Product;

public interface CartService {
    Iterable<Cart> findAll();

    Cart findById(Long id);

    void save(Cart cart);

    void remove(Long id);
}
