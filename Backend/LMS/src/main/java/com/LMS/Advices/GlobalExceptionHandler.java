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

    @ExceptionHandler(BookNotAvailableExcepiton.class)
    public ResponseEntity<ApiResponse<?>> handleBookNotAvailableExcepiton(BookNotAvailableExcepiton exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiReponse(apiError);
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

        return handleApiReponse(apiError);
    }

    @ExceptionHandler(BookNotFoundExcepiton.class)
    public ResponseEntity<ApiResponse<?>> handleBookNotFoundExcepiton(BookNotFoundExcepiton exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiReponse(apiError);
    }

    @ExceptionHandler(UserNotFoundExcetpion.class)
    public ResponseEntity<ApiResponse<?>> handleUserNotFoundException(UserNotFoundExcetpion exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiReponse(apiError);
    }

    @ExceptionHandler(BookAlreadyReturnedException.class)
    public ResponseEntity<ApiResponse<?>> handleUserNotFoundException(BookAlreadyReturnedException exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiReponse(apiError);
    }
    @ExceptionHandler(EmailDuplicateEntryException.class)
    public ResponseEntity<ApiResponse<?>> handleEmailDuplicateEntryException(EmailDuplicateEntryException exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiReponse(apiError);
    }

    @ExceptionHandler(PhoneDuplicateEntryException.class)
    public ResponseEntity<ApiResponse<?>> handlePhoneDuplicateEntryException(PhoneDuplicateEntryException exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return handleApiReponse(apiError);
    }


    /**
    /**
     * Handle optimistic locking / concurrent modification exceptions.
     * Returns 409 CONFLICT so the client can retry if desired.
     */
    @ExceptionHandler({ ObjectOptimisticLockingFailureException.class, OptimisticLockingFailureException.class })
    public ResponseEntity<ApiResponse<?>> handleOptimisticLocking(Exception ex) {
        ApiError apiError = ApiError
                .builder()
                .message("Conflict: resource was modified by another transaction. Please retry.")
                .status(HttpStatus.CONFLICT)
                .build();

        return handleApiReponse(apiError);
    }

    /**
     * Generic fallback handler for any other unhandled exceptions.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleAllExceptions(Exception exception){
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage() != null ? exception.getMessage() : "Internal Server Error")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        return handleApiReponse(apiError);
    }

    ResponseEntity<ApiResponse<?>> handleApiReponse(ApiError apiError){
        return new ResponseEntity<ApiResponse<?>>(new ApiResponse<>(apiError),apiError.getStatus());
    }
}
