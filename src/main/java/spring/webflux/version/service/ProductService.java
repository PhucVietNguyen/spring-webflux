package spring.webflux.version.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.webflux.version.model.dto.ProductDto;

public interface ProductService {

  Flux<ProductDto> findAllProduct();

  Mono<ProductDto> findProductById(Long id);
}
