package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.Cart;
import source.model.Product;
import source.repository.CartRepository;
import source.service.CartService;

public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Iterable<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(Long id) {
        return cartRepository.findOne(id);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void remove(Long id) {
        cartRepository.delete(id);
    }

}
