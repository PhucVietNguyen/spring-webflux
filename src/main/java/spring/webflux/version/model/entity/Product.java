package spring.webflux.version.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("product")
public class Product implements Serializable {

  @Id
  @Column("id")
  private Long id;

  @Column("name")
  private String name;

  @Column("price")
  private BigInteger price;
}
