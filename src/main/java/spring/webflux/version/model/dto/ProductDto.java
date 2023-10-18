package spring.webflux.version.model.dto;

import java.math.BigInteger;
import lombok.Getter;
import lombok.Setter;
import spring.webflux.version.model.entity.Product;

@Getter
@Setter
public class ProductDto {

  private Long id;

  private String name;

  private BigInteger price;

  public ProductDto(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.price = product.getPrice();
  }
}
