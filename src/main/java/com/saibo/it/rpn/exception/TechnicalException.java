package  com.saibo.it.rpn.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TechnicalException extends RuntimeException{
    String errCode;
    String errMsg;
}
