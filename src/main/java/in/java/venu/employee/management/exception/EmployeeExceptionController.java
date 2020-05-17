package in.java.venu.employee.management.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeExceptionController.class);

	@ExceptionHandler(EmployeeNotFountException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(EmployeeNotFountException ex) {
		logger.info("Entered into handleUserNotFoundException()");
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Employee Not Found", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
