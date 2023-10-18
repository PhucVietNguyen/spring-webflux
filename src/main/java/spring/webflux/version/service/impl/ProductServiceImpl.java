package spring.webflux.version.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.webflux.version.model.dto.ProductDto;
import spring.webflux.version.repository.ProductRepository;
import spring.webflux.version.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Flux<ProductDto> findAllProduct() {
    return productRepository.findAll().map(ProductDto::new);
  }

  @Override
  public Mono<ProductDto> findProductById(Long id) {
    return productRepository.findById(id).map(ProductDto::new);
  }
}
