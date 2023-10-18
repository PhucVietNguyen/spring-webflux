package spring.webflux.version.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import spring.webflux.version.handler.ProductHandler;

@Configuration(proxyBeanMethods = false)
public class ProductRouter {

  @Bean
  public RouterFunction<ServerResponse> route(ProductHandler productHandler) {
    return RouterFunctions.route()
        .path("/api/v1/product", builder -> builder
            .GET("/find-all", RequestPredicates.accept(MediaType.APPLICATION_JSON),
                productHandler::getAllProduct)
        )
        .build()
        .andRoute(RequestPredicates.GET("other"), req -> ServerResponse.ok()
            .body(Flux.just("Other route"), String.class));
  }
}
