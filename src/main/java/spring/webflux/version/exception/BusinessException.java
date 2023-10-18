package spring.webflux.version.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException{

  private String errCode;

  public String errMess;
}
