package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Cart;
import source.model.Product;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

}
