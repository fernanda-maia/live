package one.digitalinnovation.live.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WorkloadNotFound extends Exception {
    public WorkloadNotFound(Long id) {
        super("Could not found the id " + id);
    }
}
