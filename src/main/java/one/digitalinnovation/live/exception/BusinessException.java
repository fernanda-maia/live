package one.digitalinnovation.live.exception;

import one.digitalinnovation.live.util.MessageUtils;

public class BusinessException extends RuntimeException{
    public BusinessException(MessageUtils e) {
        super(e.getMessage());
    }
}
