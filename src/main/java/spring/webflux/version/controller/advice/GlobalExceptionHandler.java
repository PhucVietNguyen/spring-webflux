package spring.webflux.version.controller.advice;

import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.webflux.version.exception.BusinessException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public Mono<Void> handleException(Exception ex, ServerWebExchange exchange) {
    if (ex instanceof BusinessException) {
      exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
    }

    if (Strings.isNotBlank(ex.getMessage())) {
      byte[] bytes = ex.getMessage().getBytes(StandardCharsets.UTF_8);
      DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
      return exchange.getResponse().writeWith(Flux.just(buffer));
    }

    return Mono.error(ex);
  }
}
