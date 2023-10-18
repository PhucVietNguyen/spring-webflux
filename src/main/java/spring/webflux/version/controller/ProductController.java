package spring.webflux.version.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.webflux.version.model.dto.ProductDto;
import spring.webflux.version.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Log4j2
public class ProductController {

  private final ProductService productService;

  @GetMapping("/find-all")
  public Flux<ProductDto> findAllProduct() {
    return productService.findAllProduct();
  }

  @GetMapping("/find-by-id/{id}")
  public Mono<ProductDto> findProductById(@PathVariable("id") Long id) {
    return productService.findProductById(id);
  }
}
