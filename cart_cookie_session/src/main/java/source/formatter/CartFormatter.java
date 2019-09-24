package source.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import source.model.Cart;
import source.service.CartService;

import java.text.ParseException;
import java.util.Locale;

public class CartFormatter implements Formatter<Cart> {

    private CartService cartService;

    @Autowired
    public CartFormatter(CartService cartService){
        this.cartService = cartService;
    }

    @Override
    public Cart parse(String text, Locale locale) throws ParseException {
        return cartService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Cart object, Locale locale) {
        return "[" + object.getId() + ", " + object.getProducts() + "]";
    }
}
