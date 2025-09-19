package com.LMS.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookReturnRequestDTO {
    @NotNull(message="Please enter the ISBN")
    @Size(min = 10, max = 13, message = "ISBN must be 10 or 13 characters")
    private String isbn;

    @NotNull(message="User Id can't be empty, Please enter the User Id")
    private Long id;
}
