package com.LMS.Advices;

import com.LMS.Exceptions.*;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotAvailableException.class)
    public ResponseEntity<ApiResponse<?>> handleBookNotAvailableException(BookNotAvailableException exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiResponse(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentException(MethodArgumentNotValidException exception){
        List<String> errors = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error->error.getDefaultMessage())
                .toList();

        ApiError apiError = ApiError
                .builder()
                .message("Validation Failed")
                .status(HttpStatus.BAD_REQUEST)
                .errors(errors)
                .build();

        return handleApiResponse(apiError);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleBookNotFoundException(BookNotFoundException exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiResponse(apiError);
    }

    @ExceptionHandler(UserNotFoundExcetpion.class)
    public ResponseEntity<ApiResponse<?>> handleUserNotFoundException(UserNotFoundExcetpion exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiResponse(apiError);
    }

    @ExceptionHandler(BookAlreadyReturnedException.class)
    public ResponseEntity<ApiResponse<?>> handleUserNotFoundException(BookAlreadyReturnedException exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiResponse(apiError);
    }
    @ExceptionHandler(EmailDuplicateEntryException.class)
    public ResponseEntity<ApiResponse<?>> handleEmailDuplicateEntryException(EmailDuplicateEntryException exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiResponse(apiError);
    }

    @ExceptionHandler(PhoneDuplicateEntryException.class)
    public ResponseEntity<ApiResponse<?>> handlePhoneDuplicateEntryException(PhoneDuplicateEntryException exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiResponse(apiError);
    }

    @ExceptionHandler({ ObjectOptimisticLockingFailureException.class, OptimisticLockingFailureException.class })
    public ResponseEntity<ApiResponse<?>> handleOptimisticLocking(Exception ex) {
        ApiError apiError = ApiError
                .builder()
                .message("Conflict: resource was modified by another transaction. Please retry.")
                .status(HttpStatus.CONFLICT)
                .build();

        return handleApiResponse(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleAllExceptions(Exception exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage() != null ? exception.getMessage() : "Internal Server Error")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        return handleApiResponse(apiError);
    }

    ResponseEntity<ApiResponse<?>> handleApiResponse(ApiError apiError){
        return new ResponseEntity<ApiResponse<?>>(new ApiResponse<>(apiError),apiError.getStatus());
    }
}
