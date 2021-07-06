package one.digitalinnovation.live.exception;

import one.digitalinnovation.live.util.MessageUtils;

public class NotFoundException extends Exception {
    public NotFoundException(MessageUtils e) {
        super(e.getMessage());
    }
}
