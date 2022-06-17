package pl.uberek.ubereats.Controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value
            = { NoSuchElementException.class})
    protected ResponseEntity handleConflict(
            RuntimeException ex, WebRequest request) {
        return ResponseEntity.notFound().build();
    }
}
