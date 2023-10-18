package spring.webflux.version.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import spring.webflux.version.model.entity.Product;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
  
}
