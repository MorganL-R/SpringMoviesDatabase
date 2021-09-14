package com.morgan.api;
import com.atlassian.oai.validator.report.ValidationReport;
import com.atlassian.oai.validator.springmvc.InvalidRequestException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<List<ValidationReport.Message>> handle(final InvalidRequestException invalidRequestException) {
        return new ResponseEntity<>(invalidRequestException.getValidationReport().getMessages(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}

