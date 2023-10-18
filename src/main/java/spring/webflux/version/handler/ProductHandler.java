package spring.webflux.version.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.webflux.version.model.dto.ProductDto;
import spring.webflux.version.model.entity.Product;
import spring.webflux.version.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductHandler {

  private final ProductRepository productRepository;

  public Mono<ServerResponse> getAllProduct(ServerRequest request) {
    Flux<Product> product = productRepository.findAll();
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
        .body(product, ProductDto.class);
  }
}
