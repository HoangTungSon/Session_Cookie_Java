package source.service;

import source.model.Cart;
import source.model.Product;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);

    Iterable<Product> findAllByCart(Cart cart);
}
