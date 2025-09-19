package com.LMS.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookLoanRequestDTO {

    @NotNull(message="Please enter the ISBN")
    @Size(min = 10, max = 13, message = "ISBN must be 10 or 13 characters")
    private String isbn;

    @NotNull(message="User Id can't be empty, Please enter the User Id")
    private Long id;

    @NotNull
    @Future(message = "Due date must be in the future")
    private LocalDate dueDate;

}
